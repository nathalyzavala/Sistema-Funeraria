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
import modelodao.DaoDetalleServicio;
import modelodao.DaoProducto;
import modeloentidad.DetalleServ;

public class DetalleServicioServlet extends HttpServlet {

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
            out.println("<title>Servlet DetalleServicioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetalleServicioServlet at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("registrar")!=null) {
            try {
                int n= Integer.parseInt(request.getParameter("serviciosd"));
                int m=Integer.parseInt(request.getParameter("productosd"));
                int  si=Integer.parseInt(request.getParameter("cantidadd"));
                DetalleServ cl=new DetalleServ(n,m,si);
                new modelodao.DaoDetalleServicio().setRegistrar(cl);
                new modelodao.DaoServicio().setModificarPrecio(new modelodao.DaoDetalleServicio().PrecioServicios(n),n);
                
            } catch (SQLException e) {
                java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("Error REgistrar:"+e.getMessage());
           }
        }else if(request.getParameter("borrar")!=null){
           
            try {
                new  modelodao.DaoDetalleServicio().eliminar(new  modelodao.DaoDetalleServicio().getDetalle(request.getParameter("borrar")));
                
            }catch (SQLException ex){
                java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("no sirve");
            }
        } else if (request.getParameter("modificar") != null) {
                int id= Integer.parseInt(request.getParameter("id"));
               int n= Integer.parseInt(request.getParameter("serviciosd"));
                int m=Integer.parseInt(request.getParameter("productosd"));
                int  si=Integer.parseInt(request.getParameter("cantidadd"));
                DetalleServ cl=new DetalleServ(id,n,m,si);
            try {
                    new modelodao.DaoDetalleServicio().setModificar(cl);
                new modelodao.DaoServicio().setModificarPrecio(new modelodao.DaoDetalleServicio().PrecioServicios(n),n);
            } catch (SQLException e) {
                System.out.println("Modificarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr error");
               java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
            }

        }else if(request.getParameter("btneditar")!= null ){
            
            try {
                 DaoDetalleServicio auto= new  DaoDetalleServicio();
                DetalleServ de = auto.getDetalle(request.getParameter("btneditar"));
                request.setAttribute("modificar",de);
            } catch (SQLException ex) {
                 java.util.logging.Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         System.out.println(request.getParameter("registrar cliente"));
         request.getRequestDispatcher("DetalleServicio.jsp").forward(request, response);
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
