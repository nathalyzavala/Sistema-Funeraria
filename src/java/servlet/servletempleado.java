/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.Dao_Empleados;
import entidades.Cargo;
import entidades.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.Dao_clientes;
import modelo.entidades.Clientes;

public class servletempleado extends HttpServlet {

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
            out.println("<title>Servlet servletempleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletempleado at " + request.getContextPath() + "</h1>");
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
                new dao.Dao_Empleados().Eliminar(Integer.parseInt(request.getParameter("borrarl")));
            } catch (SQLException ex) {
//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
//            System.out.println(request.getParameter("borrar"));
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
        }
        if (request.getParameter("btneditarl") != null) {
            Empleado automodifica = Dao_Empleados.getEmpleado(request.getParameter("btneditarl"));//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("modificar", automodifica);
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
        }
        if (request.getParameter("registrarl") != null) {
            try {
                Empleado empleado = new Empleado(request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("direccion"), new Cargo(Integer.parseInt(request.getParameter("cargo"))), request.getParameter("dui"), request.getParameter("telefono"), request.getParameter("fechaContrato"), request.getParameter("fechaNacimiento"), request.getParameter("correo"));//                Logger.getLogger(servlet_clientes.class.getName()).log(Level.SEVERE, null, ex);
                Dao_Empleados.registrarEmpleado(empleado);
                request.getRequestDispatcher("empleados.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(servletempleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (request.getParameter("modificarl") != null) {
            Empleado empleado = new Empleado();            
            empleado.setId(Integer.parseInt(request.getParameter("idEmpleado")));
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setApellidos(request.getParameter("apellido"));
            empleado.setDui(request.getParameter("dui"));
            empleado.setTelefono(request.getParameter("telefono"));
            empleado.setDirecion(request.getParameter("direccion"));
            empleado.getCargo().setId(Integer.parseInt(request.getParameter("cargo")));
            empleado.setCorreo(request.getParameter("correo"));
            empleado.setFechaNacimiento(request.getParameter("fechaNacimiento"));
            
            Dao_Empleados.modificarEmpleado(empleado);
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
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
