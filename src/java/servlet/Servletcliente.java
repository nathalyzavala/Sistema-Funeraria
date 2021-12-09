/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.Dao_clientes;
import modelo.entidades.Clientes;

public class Servletcliente extends HttpServlet {

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
            out.println("<title>Servlet Servletcliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servletcliente at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("borrarl") != null) {
            try {
                new modelo.dao.Dao_clientes().Eimininar(request.getParameter("borrarl"));
            } catch (SQLException ex) {
//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
//            System.out.println(request.getParameter("borrar"));
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
         if (request.getParameter("btneditarl") != null) {
            try {
                Dao_clientes autorrecuperado = new Dao_clientes();
                Clientes automodifica = autorrecuperado.getClientes(request.getParameter("btneditarl"));
                request.setAttribute("modificar", automodifica);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            } catch (SQLException ex) {
//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if (request.getParameter("registrarl") != null) {
            try {
                Clientes cliente = new Clientes();

                cliente.setDuic(request.getParameter("dui"));
                cliente.setNombrec(request.getParameter("nombre"));
                cliente.setApellidoc(request.getParameter("apellido"));
                cliente.setTelefono(request.getParameter("telefono"));
                cliente.setDireccionc(request.getParameter("direccion"));

                new modelo.dao.Dao_clientes().setRegistrarl(cliente);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            } catch (SQLException ex) {
//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
            if (request.getParameter("modificarl") != null) {
            try {
                Clientes cliente = new Clientes();
                cliente.setId_cliente(request.getParameter("idemple"));
                cliente.setDuic(request.getParameter("dui"));
                cliente.setNombrec(request.getParameter("nombre"));
                cliente.setApellidoc(request.getParameter("apellido"));
                cliente.setTelefono(request.getParameter("telefono"));
                cliente.setDireccionc(request.getParameter("direccion"));

                new modelo.dao.Dao_clientes().SetModificar(cliente);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            } catch (SQLException ex) {
//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
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
