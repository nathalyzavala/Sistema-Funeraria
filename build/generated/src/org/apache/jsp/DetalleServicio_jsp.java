package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelodao.DaoServicio;
import modeloentidad.producto;
import modelodao.DaoProducto;
import java.util.ArrayList;
import modeloentidad.servicio;
import modelodao.DaoDetalleServicio;
import modeloentidad.DetalleServ;

public final class DetalleServicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
 modelodao.DaoDetalleServicio detalles = new DaoDetalleServicio();
        modelodao.DaoProducto produ = new DaoProducto();
        modelodao.DaoServicio daoSer = new DaoServicio();
        DetalleServ modificar = (DetalleServ) request.getAttribute("modificar");
    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Detalles del servicio</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .divScroll{\n");
      out.write("                display: block;\n");
      out.write("                max-height: 480px;\n");
      out.write("                overflow-y: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table thead {\n");
      out.write("                position: -webkit-sticky;\n");
      out.write("                position: sticky;\n");
      out.write("                top: 0;\n");
      out.write("                z-index: 5;\n");
      out.write("                background: #fff;\n");
      out.write("            }\n");
      out.write("            .table-wrapper-scroll-y {\n");
      out.write("\n");
      out.write("                margin: 0 auto;\n");
      out.write("                display: block;\n");
      out.write("                max-height: 170px;\n");
      out.write("                overflow-y: auto;\n");
      out.write("                -ms-overflow-style: -ms-autohiding-scrollbar;\n");
      out.write("                width: 70%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .divScroll{\n");
      out.write("                display: block;\n");
      out.write("                max-height: 480px;\n");
      out.write("                overflow-y: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .registro{\n");
      out.write("                display: block;\n");
      out.write("                max-height: 430px;\n");
      out.write("                overflow-y: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("        function validar_desplegable() {\n");
      out.write("\n");
      out.write("            if (document.formu.cantidad <= 0) {\n");
      out.write("                alert(\"Cantidad de Productos debe Ser mayor a Cero\");\n");
      out.write("                document.formu.cantidad.focus();\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("        function escogerServicio() {\n");
      out.write("            if (document.servicios.serviciotabla.selectedIndex == 0) {\n");
      out.write("                alert(\"Debe seleccionar un Servicio para mostrar .\");\n");
      out.write("                document.formu.serviciosd.focus();\n");
      out.write("                return 0;\n");
      out.write("            } else {\n");
      out.write("                document.servicios.submit();\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("        function producto() {\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        function limpiar() {\n");
      out.write("            location.reload();\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("        function seleccion() {\n");
      out.write("            document.getElementById(\"serv\").options.item(0).selected = 'selected';\n");
      out.write("            escogerServicio();\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("\n");
      out.write("        function validacionNumber() {\n");
      out.write("            document.formu.action = \"DetalleServicio.jsp\";\n");
      out.write("            document.formu.submit();\n");
      out.write("        }\n");
      out.write("        ;\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <body class=\"bg-light text-dark\">\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light rounded\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Funeraria</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExample09\" aria-controls=\"navbarsExample09\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarsExample09\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    \n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Ventas</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"detalleVenta.jsp\">Realizar Venta</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"listaVentas.jsp\">Lista Ventas</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Servicios</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Servicios.jsp\">Servicios (Agregar, Lista)</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"DetalleServicio.jsp\">Detalles de servicios</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Productos</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Productos.jsp\">Productos (Agregar, Lista)</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Empleados</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"empleados.jsp\">Empleados (Agregar, Lista)</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"empleados.jsp\">Cargo (Agregar, Lista)</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Clientes</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"cliente.jsp\">Clientes (Agregar, Lista)</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Fiadores</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\"> \n");
      out.write("                            <a class=\"dropdown-item\" href=\"FiadorRegistro.jsp\">Agregar</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Fiadormuestra.jsp\">Lista</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown09\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Reportes</a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdown09\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte1.jsp\">Reporte Empleados</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte2.jsp\">Reporte Clientes</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte3.jsp\">Reporte Detalles de Servicios</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte4.jsp\">Reporte Clientes y Fiadores</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte5.jsp\">Reporte Clientes Pago Contado</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte6.jsp\">Reporte Clientes Pago Cuota</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte7.jsp\">Reporte Cantidad Servicio Vendidos</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte8.jsp\">Reporte de Empledos Con mas Ventas Registradas</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"vistaUtilerias/reporte9.jsp\">Reporte Ventas por Servicios</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Login.jsp\">Cerrar Sesión</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1 class=\"text-center\">Registro de droductos de servicios</h1>\n");
      out.write("        <div class=\"container rounded divScroll\" style=\"border: 1px solid black; padding: 20px; background-color: white\">\n");
      out.write("            <div class=\"row\"> \n");
      out.write("                <div class=\"col\">\n");
      out.write("\n");
      out.write("                    <form action=\"DetalleServicioServlet\" method=\"post\" name=\"formu\">\n");
      out.write("\n");
      out.write("                        ");

                            servicio auxDetalle = null;

                            int auxServicio = -1;
                            int auxProducto = -1;

                            if (request.getParameter("serviciotabla") != null) {
                                auxDetalle = daoSer.getServicios(request.getParameter("serviciotabla"));
                            }

                            if (request.getParameter("productosd") != null) {
                                auxProducto = Integer.parseInt(request.getParameter("productosd"));
                            }

                            if (request.getParameter("serviciosd") != null) {
                                auxServicio = Integer.parseInt(request.getParameter("serviciosd"));
                            }

                        
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <label>Seleccionar Servicio:</label>\n");
      out.write("                            <select name=\"serviciosd\"  onchange=\"validacionNumber()\" required class=\"form-control\">\n");
      out.write("                                ");
for (servicio detalle : detalles.getServicios()) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print(detalle.getId_servicio());
      out.write('"');
      out.write(' ');
      out.print( (modificar != null) ? ((modificar.getId_servicio() == detalle.getId_servicio()) ? "selected" : "") : (auxServicio == detalle.getId_servicio()) ? "selected" : "");
      out.write(' ');
      out.write('>');
      out.print(detalle.getNombreServicio());
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"hidden\"   name=\"id\" value=\"");
      out.print((modificar == null) ? "" : modificar.getId_detalleservicio());
      out.write("\" >\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <div >\n");
      out.write("                        <label>Seleccionar Producto:</label>\n");
      out.write("                        <select name=\"productosd\" required onchange=\"validacionNumber()\" class=\"form-control\">\n");
      out.write("                            ");

                                for (producto detalle : produ.getProductoP()) {
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(detalle.getIdproducto());
      out.write('"');
      out.print( (modificar != null) ? ((modificar.getId_producto() == detalle.getIdproducto()) ? "selected" : "") : (auxProducto == detalle.getIdproducto()) ? "selected" : "");
      out.write(' ');
      out.write('>');
      out.print(detalle.getNombrproducto());
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <div>\n");
      out.write("                        ");
 String nombreProducto = produ.getProdu(auxProducto + "").getNombrproducto();
      out.write("\n");
      out.write("                        <label for=\"cantidadd\">Cantidad Productos:</label>\n");
      out.write("                        <input type=\"number\" min=\"1\" max=\"1000\" class=\"form-control\" value=\"");
      out.print((modificar == null) ? ((nombreProducto != null) ? ((nombreProducto.toLowerCase().contains("caja funebre")) ? "1" : "") : "") : modificar.getCantidad());
      out.write("\"   id=\"cantidadd\"  name=\"cantidadd\"  required ");
      out.print((nombreProducto != null) ? ((nombreProducto.toLowerCase().contains("caja funebre")) ? "readonly" : "") : "");
      out.write(">\n");
      out.write("\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\"><label>&nbsp;</label></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col text-right\">\n");
      out.write("                    <input onclick=\"validar_desplegable()\" class=\"btn btn-secondary\" type=\"submit\" value=\"");
      out.print((modificar == null) ? "Registrar" : "Modificar");
      out.write("\" name=\"");
      out.print((modificar == null) ? "registrar" : "modificar");
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <input onclick=\"limpiar()\" type=\"submit\" class=\"btn btn-secondary\" name=\"cancelar\" value=\"Cancelar\">  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div class=\"col\">\n");
      out.write("                <label>&nbsp;</label>\n");
      out.write("                <form action=\"DetalleServicioServlet\" method=\"post\" id=\"servicios\" name=\"servicios\">\n");
      out.write("                    <div >\n");
      out.write("                        <select name=\"serviciotabla\" onchange=\"escogerServicio()\" class=\"form-control\">\n");
      out.write("                            <option value=\"SELECCIONAR\" id=\"serv\">Seleccionar Servicio a Mostrar:</option>\n");
      out.write("                            ");

                                for (servicio detalle : detalles.getServicios()) {
                            
      out.write("\n");
      out.write("                            <option onclick=\"limpiar()\" value=\"");
      out.print(detalle.getId_servicio());
      out.write('"');
      out.write(' ');
      out.print( (auxDetalle != null) ? ((auxDetalle.getId_servicio() == detalle.getId_servicio()) ? "selected" : "") : "");
      out.write(' ');
      out.write('>');
      out.print(detalle.getNombreServicio());
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col\">\n");
      out.write("                <label>&nbsp;</label>\n");
      out.write("                ");

                    if (auxDetalle != null) {
                
      out.write("\n");
      out.write("                <div class=\"table-wrapper-scroll-y\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead class=\"text-center thead-dark\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\">Producto</th>\n");
      out.write("                                <th scope=\"col\">Cantidad</th>\n");
      out.write("                                <th colspan=\"2\" scope=\"col\">Acción</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        <tbody class=\"text-center \">\n");
      out.write("                            ");

                                    for (DetalleServ cl : detalles.getDetallesServiciosProductos(auxDetalle.getId_servicio())) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(cl.getProdu().getNombrproducto());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(cl.getCantidad());
      out.write("</td>\n");
      out.write("                                <td><button type=\"submit\"name=\"btneditar\" class=\"btn btn-primary\" onclick=\"enviar()\" value=\"");
      out.print(cl.getId_detalleservicio());
      out.write("\"  >Editar</button>&nbsp;\n");
      out.write("                                    &nbsp;&nbsp;\n");
      out.write("                                <button type=\"submit\" name=\"borrar\" class=\"btn btn-primary\" onclick=\"enviar()\"  value=\"");
      out.print(cl.getId_detalleservicio());
      out.write("\" >Borrar</button></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
                                    }
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("    </div>                                        \n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
