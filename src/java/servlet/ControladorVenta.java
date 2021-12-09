/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.Dao_Servicios;
import dao.Dao_Venta;
import entidades.Cargo;
import entidades.Cliente;
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

public class ControladorVenta extends HttpServlet {

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
            out.println("<title>Servlet ControladorVenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVenta at " + request.getContextPath() + "</h1>");
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

        

        System.out.println("parametro: " + request.getParameter("eliminarRegistro"));

        if (request.getParameter("eliminarRegistro") != null) {
            if (Dao_Venta.eliminarVenta(Integer.parseInt(request.getParameter("eliminarRegistro")))) {
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=listaVentas.jsp'>");

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
                    out.write("                            <h4 class=\"text-center\">Registro Eliminado</h4>\n");
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
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=listaVentas.jsp'>");

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
                    out.write("                            <h4 class=\"text-center\">No se pudo eliminar el registro</h4>\n");
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

        if (request.getParameter("registrarCliente") != null) {
            try {
                Cliente cliente = new Cliente(request.getParameter("duiCliente"), request.getParameter("nombreCliente"), request.getParameter("apellidoCliente"), request.getParameter("telefonoCliente"), request.getParameter("direccionCliente"));
                if (dao.Dao_Clientes.setRegistrar(cliente)) {
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
                        out.write("                            <h4 class=\"text-center\">Cliente registrado</h4>\n");
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
                } else {
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
                        out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Error</h5>\n");
                        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                        out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                        out.write("                        </button>\n");
                        out.write("                    </div>\n");
                        out.write("                    <div class=\"modal-body\">\n");
                        out.write("                        <div class=\"tabla_modal\">\n");
                        out.write("                            <h4 class=\"text-center\">No se puede registrar el cliente</h4>\n");
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
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("registrarEmpleado") != null) {
            try {
                Empleado empleado = new Empleado(request.getParameter("nombreEmpleado"), request.getParameter("apellidoEmpleado"), request.getParameter("direccionEmpleado"), new Cargo(Integer.parseInt(request.getParameter("cargo"))), request.getParameter("duiEmpleado"), request.getParameter("telefonoEmpleado"), request.getParameter("fechaContrato"), request.getParameter("fechaNacimiento"),request.getParameter("correoEmpleado"));
                if (dao.Dao_Empleados.registrarEmpleado(empleado)) {
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
                        out.write("                            <h4 class=\"text-center\">Empleado registrado</h4>\n");
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
                } else {
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
                        out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Error</h5>\n");
                        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
                        out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
                        out.write("                        </button>\n");
                        out.write("                    </div>\n");
                        out.write("                    <div class=\"modal-body\">\n");
                        out.write("                        <div class=\"tabla_modal\">\n");
                        out.write("                            <h4 class=\"text-center\">No se puede registrar el empleado</h4>\n");
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
            } catch (SQLException ex) {
                Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("devolver")!=null) {
            String[] parametro = request.getParameter("devolver").split("-");
            System.out.println(parametro[0]+ " " + parametro[1]);
            if (Dao_Servicios.devolucion(Dao_Servicios.getDetalles(Integer.parseInt(parametro[1])), Integer.parseInt(parametro[0]))) {

                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=listaVentas.jsp'>");

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
                    out.write("                            <h4 class=\"text-center\">Devolución completada</h4>\n");
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
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.print("<html>");
                    out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
                    out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
                    out.write("        <script src=\"js/jquery.js\"></script>\n");
                    out.write("        <script src=\"js/bootstrap.js\"></script>\n");
                    out.println("<meta http-equiv='refresh' content='1;URL=listaVentas.jsp'>");

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
                    out.write("                            <h4 class=\"text-center\">Error en la devolución</h4>\n");
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
