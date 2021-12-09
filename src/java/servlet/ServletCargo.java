/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.Dao_cargo;
import modelo.entidades.Cargo;

public class ServletCargo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCargo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCargo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getParameter("borrarc") != null) {
            try {
                new modelo.dao.Dao_cargo().Eimininar(request.getParameter("borrarc"));
            } catch (SQLException e) {
                //Logger.getLogger(Servlet_empleados.class.getName()).log(Level.SEVERE, null, e);
            }
//            System.out.println(request.getParameter("borrar"));
            request.getRequestDispatcher("cargo.jsp").forward(request, response);
        }

        if (request.getParameter("registrar") != null) {
            try {
                
                Cargo nuevo = new Cargo();

                String cargo = request.getParameter("salario");
                double idc = Double.parseDouble(cargo);

                nuevo.setNombre(request.getParameter("nombre"));
                nuevo.setSalario(idc);
                new modelo.dao.Dao_cargo().setRegistrar(nuevo);
            } catch (SQLException e) {
//                Logger.getLogger(Servlet_cargo.class.getName()).log(Level.SEVERE, null, e);
            }
            request.getRequestDispatcher("cargo.jsp").forward(request, response);
        }
        if (request.getParameter("modificarc") != null) {
            Cargo nuev = new Cargo();
            nuev.setId_cargo(request.getParameter("idcargo"));
            nuev.setNombre(request.getParameter("nombre"));
            nuev.setSalario(Double.parseDouble(request.getParameter("salario")));
            try {
                new modelo.dao.Dao_cargo().SetModificarC(nuev);

            } catch (SQLException ex) {
//                Logger.getLogger(Servlet_cargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("cargo.jsp").forward(request, response);
        }
        
        System.out.println("ditar: " + request.getParameter("btneditarc"));
        
        if (request.getParameter("btneditarc") != null) {
            try {
                Dao_cargo autorrecuperado = new Dao_cargo();
                Cargo automodific = autorrecuperado.getCargoCC(request.getParameter("btneditarc"));
                request.setAttribute("modificar", automodific);
                request.getRequestDispatcher("cargo.jsp").forward(request, response);
            } catch (SQLException ex) {
//                Logger.getLogger(Servlet_cargo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
