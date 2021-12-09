package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.entidades.Cargo;
import modelo.dao.Dao_cargo;

public final class cargo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
 modelo.dao.Dao_cargo cargo = new Dao_cargo();
      out.write("\n");
      out.write("    ");
 Cargo modificar = (Cargo) request.getAttribute("modificar");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cargo</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("        <style>\n");
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
      out.write("                max-height: 350px;\n");
      out.write("                overflow-y: auto;\n");
      out.write("                -ms-overflow-style: -ms-autohiding-scrollbar;\n");
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
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function pregunta() {\n");
      out.write("                if (confirm('¿Desea eliminar cargo?')) {\n");
      out.write("                    document.tuformulario.submit();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("\n");
      out.write("            function validarNombre() {\n");
      out.write("                if (!$('input').is('[readonly]')) {\n");
      out.write("                    if (document.getElementById(\"nombre\").value != \"\") {\n");
      out.write("                        document.getElementById('form').action = 'cargo.jsp';\n");
      out.write("                        document.getElementById('form').submit();\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light text-dark\">\n");
      out.write("\n");
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
      out.write("                           <a class=\"dropdown-item\" href=\"cargo.jsp\">Cargo (Agregar, Lista)</a>\n");
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
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Login.jsp\">Cerrar Sesión</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        ");

            Cargo validacion = null;
            System.out.println("" + request.getParameter("nombre"));
            if (request.getParameter("nombre") != null) {
                validacion = new Cargo();
                if (Dao_cargo.validarNombre(request.getParameter("nombre"))) {
                    validacion.setNombre("");

                } else {
                    validacion.setNombre(request.getParameter("nombre"));
                }
                if (request.getParameter("salario").isEmpty()) {
                    validacion.setSalario(0);
                } else {
                    validacion.setSalario(Double.parseDouble(request.getParameter("salario")));
                }
            }

            if (request.getParameter("registrar") != null || request.getParameter("modificarc") != null) {
                validacion = null;
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <h1 class=\"text-center\">");
      out.print((modificar == null) ? "Nuevo" : "Editar");
      out.write(" Cargo</h1>\n");
      out.write("        <div class=\"container rounded divScroll\" style=\"border: 1px solid black; padding: 20px; background-color: white;\">\n");
      out.write("\n");
      out.write("            <form action=\"ServletCargo\" method=\"post\" id=\"form\">\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" name=\"idcargo\" value=\"");
      out.print((modificar == null) ? "" : modificar.getId_cargo());
      out.write("\"/>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"\">Nombre del cargo: </label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" onblur=\"validarNombre()\" id=\"nombre\" name=\"nombre\" value=\"");
      out.print((modificar == null) ? ((validacion == null) ? "" : validacion.getNombre()) : modificar.getNombre());
      out.write("\"placeholder=\"Ej: Motorista\" required ");
      out.print((modificar == null) ? "" : "readonly");
      out.write("/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"\">Salario </label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"salario\"  min=”0″ max=”20000″ step=\"0.01\" value=\"");
      out.print((modificar == null) ? ((validacion == null) ? "" : validacion.getSalario()) : modificar.getSalario());
      out.write("\" placeholder=\"Ej: $ 100.00\" required/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col text-center\">  \n");
      out.write("                        <input type=\"submit\"   class=\"btn btn-secondary\"\n");
      out.write("                               value=\"");
      out.print((modificar == null) ? "Guardar" : "Modificar");
      out.write("\"\n");
      out.write("                               name=\"");
      out.print((modificar == null) ? "registrar" : "modificarc");
      out.write("\" />\n");
      out.write("                        <input type=\"button\" onclick=\"location.href = 'cargo.jsp'\" value=\"Cancelar\" class=\"btn btn-secondary\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <form action=\"ServletCargo\" method=\"post\">\n");
      out.write("                <div class=\"table-wrapper-scroll-y\" style=\"width: 60%;\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead class=\"thead-dark text-center\">\n");
      out.write("                            <tr>\n");
      out.write("\n");
      out.write("                                <th scope=\"col\">Nombre</th>\n");
      out.write("                                <th scope=\"col\">Salario</th>\n");
      out.write("                                <th scope=\"col\">Acción</th>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <br></br>\n");
      out.write("                        <tbody class=\"text-center\">\n");
      out.write("                            ");

                                for (Cargo cli : cargo.getCargo()) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(cli.getNombre());
      out.write("</td>\n");
      out.write("                                <td>$");
      out.print(String.format("%.2f", cli.getSalario()));
      out.write("</td>\n");
      out.write("\n");
      out.write("                                <td>\n");
      out.write("                                    <button class=\"btn btn-primary readMore roundBtn\" name=\"btneditarc\" value=\"");
      out.print(cli.getId_cargo());
      out.write("\">Editar</button>\n");
      out.write("                                    &nbsp;&nbsp;&nbsp;\n");
      out.write("                                    <button class=\"btn btn-primary readMore roundBtn\" name=\"borrarc\"  onclick=\"pregunta()\" value=\"");
      out.print(cli.getId_cargo());
      out.write("\">Borrar</button>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
