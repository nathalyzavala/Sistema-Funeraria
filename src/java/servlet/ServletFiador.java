/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.dao_fiador;
import modelo.entidades.Fiador;


public class ServletFiador extends HttpServlet {

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
            out.println("<title>Servlet ServletFiador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFiador at " + request.getContextPath() + "</h1>");
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
        System.out.println("eliminar: " + request.getParameter("eliminarRegistro"));
        if(request.getParameter("eliminarRegistro")!=null){
            try {
                new modelo.dao.dao_fiador().Eliminar(Integer.parseInt(request.getParameter("eliminarRegistro")));
            } catch (Exception e) {
                Logger.getLogger(ServletFiador.class.getName()).log(Level.SEVERE,null,e);
            }
            response.sendRedirect("Fiadormuestra.jsp");
        }
        if(request.getParameter("insertar")!=null){                                                                                                 
            try{
                Fiador fiador = new Fiador(request.getParameter("nombre"),request.getParameter("direccion"),request.getParameter("telefono"),Integer.parseInt(request.getParameter("cliente")),request.getParameter("dui"));
                new modelo.dao.dao_fiador().setRegistrar(fiador);
                try (PrintWriter out= response.getWriter()){
            response.sendRedirect("Fiadormuestra.jsp");
        }
            }catch(Exception e){
                Logger.getLogger(ServletFiador.class.getName()).log(Level.SEVERE,null,e);
            }    
        }
        System.out.println("editar: " + request.getParameter("editar"));
        if(request.getParameter("editar")!=null){
            try{
               Fiador fiador = new Fiador(Integer.parseInt(request.getParameter("editar")),request.getParameter("nombre"),request.getParameter("direccion"),request.getParameter("telefono"),Integer.parseInt(request.getParameter("cliente")),request.getParameter("dui"));
                new modelo.dao.dao_fiador().setModificar(fiador);
                try (PrintWriter out= response.getWriter()){
                response.sendRedirect("Fiadormuestra.jsp");
                }
                
            }catch(Exception e){
                Logger.getLogger(ServletFiador.class.getName()).log(Level.SEVERE,null,e);
            }    
        }
        if(request.getParameter("btneditar")!=null){
            try (PrintWriter out= response.getWriter()){
                dao_fiador autorec = new dao_fiador();
                Fiador fiador= autorec.MostrarUnFiador(Integer.parseInt(request.getParameter("btneditar")));
                request.setAttribute("editar", fiador);
                response.sendRedirect("FiadorEdit.jsp");
        }
        }
        if(request.getParameter("mostrar")!=null){
             try (PrintWriter out= response.getWriter()){
            response.sendRedirect("Fiadormuestra.jsp");
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
