/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.Dao_Login;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorLogin extends HttpServlet {

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
            out.println("<title>Servlet ControladorLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLogin at " + request.getContextPath() + "</h1>");
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
        
        if(request.getParameter("iniciar")!=null){
            if(dao.Dao_Login.iniciarSesion(entidades.Encriptacion.sha1(request.getParameter("usuario")), entidades.Encriptacion.sha1(request.getParameter("contrasena")))){
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=detalleVenta.jsp'>");

                    out.print("<body>");
                    out.write("        <div class=\"modal fade\" id=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
                    out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
                    out.write("                <div class=\"modal-content\">\n");
                    out.write("                    <div class=\"modal-header\">\n");
                    out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Exito</h5>\n");
                    out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                    out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                    out.write("                        </button>\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-body\">\n");
                    out.write("                        <div class=\"tabla_modal\">\n");
                    out.write("                            <h4 class=\"text-center\">Inicio de sesión correcto</h4>\n");
                    out.write("                            \n");
                    out.write("                        </div>\n");
                    out.write("\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-footer\">\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("            </div>\n");
                    out.write("        </div>\n");
                    out.write("        ");
                    out.write("   \n");
                    out.write("        <script>\n");
                    out.write("            $(\"#modal\").modal();\n");
                    out.write("        </script>\n");
                    out.write("        ");

                }
            }else{
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=Login.jsp'>");

                    out.print("<body>");
                    out.write("        <div class=\"modal fade\" id=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
                    out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
                    out.write("                <div class=\"modal-content\">\n");
                    out.write("                    <div class=\"modal-header\">\n");
                    out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Error</h5>\n");
                    out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                    out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                    out.write("                        </button>\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-body\">\n");
                    out.write("                        <div class=\"tabla_modal\">\n");
                    out.write("                            <h4 class=\"text-center\">Error al iniciar sesión</h4>\n");
                    out.write("                            \n");
                    out.write("                        </div>\n");
                    out.write("\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-footer\">\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("            </div>\n");
                    out.write("        </div>\n");
                    out.write("        ");
                    out.write("   \n");
                    out.write("        <script>\n");
                    out.write("            $(\"#modal\").modal();\n");
                    out.write("        </script>\n");
                    out.write("        ");

                }
            }
        }
        
        if(request.getParameter("cambiar")!=null){
            String usuario = request.getParameter("user");
            String contra = request.getParameter("contra");
            System.out.println("Ususario:"+request.getParameter("idempleado"));
            Usuario usurio = new Usuario(Integer.parseInt(request.getParameter("idempleado")), usuario, contra);
            
            if(Dao_Login.cambiarCredenciales(usurio)){
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=Login.jsp'>");

                    out.print("<body>");
                    out.write("        <div class=\"modal fade\" id=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
                    out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
                    out.write("                <div class=\"modal-content\">\n");
                    out.write("                    <div class=\"modal-header\">\n");
                    out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Exito</h5>\n");
                    out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                    out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                    out.write("                        </button>\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-body\">\n");
                    out.write("                        <div class=\"tabla_modal\">\n");
                    out.write("                            <h4 class=\"text-center\">Datos de inicio cambiados</h4>\n");
                    out.write("                            \n");
                    out.write("                        </div>\n");
                    out.write("\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-footer\">\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("            </div>\n");
                    out.write("        </div>\n");
                    out.write("        ");
                    out.write("   \n");
                    out.write("        <script>\n");
                    out.write("            $(\"#modal\").modal();\n");
                    out.write("        </script>\n");
                    out.write("        ");

                }
            }else{
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=Login.jsp'>");

                    out.print("<body>");
                    out.write("        <div class=\"modal fade\" id=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
                    out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
                    out.write("                <div class=\"modal-content\">\n");
                    out.write("                    <div class=\"modal-header\">\n");
                    out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Error</h5>\n");
                    out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                    out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                    out.write("                        </button>\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-body\">\n");
                    out.write("                        <div class=\"tabla_modal\">\n");
                    out.write("                            <h4 class=\"text-center\">No se pueden cambiar los datos</h4>\n");
                    out.write("                            \n");
                    out.write("                        </div>\n");
                    out.write("\n");
                    out.write("                    </div>\n");
                    out.write("                    <div class=\"modal-footer\">\n");
                    out.write("                    </div>\n");
                    out.write("                </div>\n");
                    out.write("            </div>\n");
                    out.write("        </div>\n");
                    out.write("        ");
                    out.write("   \n");
                    out.write("        <script>\n");
                    out.write("            $(\"#modal\").modal();\n");
                    out.write("        </script>\n");
                    out.write("        ");

                }
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
