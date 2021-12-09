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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelodao.DaoProducto;
import modeloentidad.producto;

public class ProductoServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoServlet at " + request.getContextPath() + "</h1>");
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
        producto modifi = null;
        if (request.getParameter("registrar") != null) {
            try {
                producto cl = new producto();
                if(request.getParameter("tipo").equals("1")){
                     cl.setNombrproducto("Caja Funebre  "+request.getParameter("nombrep"));
                }else{
                     cl.setNombrproducto(request.getParameter("nombrep"));
                }
                cl.setPrecioproducto(Float.parseFloat(request.getParameter("precio")));
                cl.setCantidadproducto(Integer.parseInt(request.getParameter("cantidad")));
                new modelodao.DaoProducto().setRegistrarP(cl);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        } else if (request.getParameter("borrar") != null) {
            try {
                new modelodao.DaoProducto().eliminar(new modelodao.DaoProducto().getProdu(request.getParameter("borrar")));
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("no sirve");
            }
        } else if (request.getParameter("modificar") != null) {
            producto cl = new producto();
            
            System.out.println("ver tipo:" + request.getParameter("tipo").equals("1"));
            if(Integer.parseInt(request.getParameter("tipo"))==1){
                     cl.setNombrproducto("Caja Funebre  "+request.getParameter("nombrep"));
                }else{
                     cl.setNombrproducto(request.getParameter("nombrep"));
                }
            
            System.out.println("nombre prodcto: " + cl.getNombrproducto());
            
            cl.setIdproducto(Integer.parseInt(request.getParameter("id")));
            
            cl.setPrecioproducto(Float.parseFloat(request.getParameter("precio")));
            cl.setCantidadproducto(Integer.parseInt(request.getParameter("cantidad")));
            try {
                new modelodao.DaoProducto().setModificar(cl);
            } catch (SQLException e) {
                java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
            }

        } else if (request.getParameter("btneditar") != null) {

            try {
                DaoProducto auto = new DaoProducto();
                modifi = auto.getProdu(request.getParameter("btneditar"));
                request.setAttribute("modificar", modifi);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al editar");
            }
        }
        request.getRequestDispatcher("Productos.jsp").forward(request, response);
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
