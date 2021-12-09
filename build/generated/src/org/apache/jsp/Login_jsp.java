package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.Dao_Login;
import dao.Dao_Empleados;
import entidades.Empleado;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inicio de sesión</title>\n");
      out.write("        <link rel=\"icon\" href=\"imagenes/icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("        \n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            .centrar {\n");
      out.write("                overflow: hidden;\n");
      out.write("                position: absolute;\n");
      out.write("                width: 35%;\n");
      out.write("                top: 20%;\n");
      out.write("                left: 33%;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body class=\"bg-light text-dark\">\n");
      out.write("\n");
      out.write("        <!--Modales-->\n");
      out.write("\n");
      out.write("        <!--Modal existe correo-->\n");
      out.write("        <div class=\"modal fade\" id=\"modalExiste\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Código de recuperación enviado</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                        <h5 class=\"text-center\">Código enviado al correo electronico</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Modal no existe correo-->\n");
      out.write("        <div class=\"modal fade\" id=\"noExiste\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("              \t  <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Error al enviar el código de recuperación</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <h5 class=\"text-center\">No existe el correo introducido</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" onclick=\"location.href = 'Login.jsp'\">Cerrar</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Fin modales-->\n");
      out.write("\n");
      out.write("        ");


            if (request.getParameter("recuperar") == null && request.getParameter("enviarCodigo") == null && request.getParameter("validarCodigo") == null) {
        
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("        \n");
      out.write("        <div class=\"container rounded centrar text-center\" style=\"background-color: #fff; border: 1px solid black;\">\n");
      out.write("        \t\n");
      out.write("            <h3 class=\"text-center\">Iniciar Sesión</h3>\n");
      out.write("            <h1 class=\"text-center\">Funeraria la esperanza</h1>\n");
      out.write("            <div class=\"input-group mb-3 text-center\" style=\"margin-left: 38%;\">\n");
      out.write("            \t<img src=\"imagenes/logoReporte.png\" style=\"width: 25%;height: 25%;\">\n");
      out.write("        \t</div>\n");
      out.write("            <form action=\"ControladorLogin\" method=\"post\" name=\"login\">\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group-prepend\">\n");
      out.write("                        <span class=\"input-group-text\" id=\"basic-addon1\"><img src=\"imagenes/user.png\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Usuario\" aria-label=\"Usuario\" aria-describedby=\"basic-addon1\" name=\"usuario\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group-prepend\">\n");
      out.write("                        <span class=\"input-group-text\" id=\"basic-addon1\"><img src=\"imagenes/pass.png\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" placeholder=\"Contraseña\" aria-label=\"Contraseña\" aria-describedby=\"basic-addon1\" name=\"contrasena\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" name=\"iniciar\" value=\"Iniciar Sesión\" class=\"btn btn-secondary\">\n");
      out.write("                    <input type=\"reset\" name=\"limpiar\" value=\"Limpiar\" class=\"btn btn-secondary\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("            </form>\n");
      out.write("            <form method=\"post\" action=\"Login.jsp\">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <p><button type=\"submit\" onclick=\"recuperarContra()\" name=\"recuperar\" class=\"btn btn-outline-secondary\">¿No puedes iniciar sesión?</button></p>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");
} else if (request.getParameter("enviarCodigo") == null && request.getParameter("validarCodigo") == null) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container rounded centrar\" style=\"background-color: #fff; border: 1px solid black;\">\n");
      out.write("            <h3 class=\"text-center\">Codigo para recuperar la cuenta</h3>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"Login.jsp\" method=\"post\" name=\"nuevo\">\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                            <div class=\"input-group-text\"><img src=\"imagenes/icons8-new-post-64.png\" style=\"width: 16px; height: 16px\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"email\" name=\"correo\" class=\"form-control\" placeholder=\"correoEmpleado@ejemplo.com\" required>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" name=\"enviarCodigo\" value=\"Enviar codigo de recuperación\" class=\"btn btn-secondary\">\n");
      out.write("                    <input type=\"button\" onclick=\"location.href = 'Login.jsp'\" value=\"cancelar\" class=\"btn btn-secondary\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
} else if (request.getParameter("enviarCodigo") != null) {
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String codigo = Empleado.codigoRecuperacion();
            String email = request.getParameter("correo");
            System.out.println(email);
            boolean existeCorreo = Dao_Login.existeCorreo(email);
            if (existeCorreo) {
                if (Empleado.enviarCorreo(codigo, email)) {
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            }
        } else {
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
if (existeCorreo) {
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(\"#modalExiste\").modal();\n");
      out.write("        </script>\n");
      out.write("        <div class=\"container rounded centrar\" style=\"background-color: #fff; border: 1px solid black;\">\n");
      out.write("            <h3 class=\"text-center\">Introduzca el código que fue enviado</h3>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"Login.jsp\" method=\"post\" name=\"nuevo\">\n");
      out.write("                <input type=\"hidden\" name=\"auxCodigo\" value=\"");
      out.print(codigo);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"auxCorreo\" value=\"");
      out.print(request.getParameter("correo"));
      out.write("\">\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                            <div class=\"input-group-text\"><img src=\"imagenes/icons8-safe-ok-48.png\" style=\"width: 16px; height: 16px\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"inputCodigo\" placeholder=\"Código\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" name=\"validarCodigo\" value=\"Recuperar Cuenta\" class=\"btn btn-secondary\">\n");
      out.write("                    <input type=\"button\" onclick=\"location.href = 'Login.jsp'\" value=\"cancelar\" class=\"btn btn-secondary\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(\"#noExiste\").modal();\n");
      out.write("        </script>\n");
      out.write("        ");

            }
      out.write("\n");
      out.write("        ");
} else {
            String codigo = request.getParameter("auxCodigo");
            String input = request.getParameter("inputCodigo");
            if (codigo.equals(input)) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container rounded centrar\" style=\"background-color: #fff; border: 1px solid black;\">\n");
      out.write("            <h3 class=\"text-center\">Cambio de credenciales de inicio</h3>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"ControladorLogin\" method=\"post\" name=\"nuevo\">\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(Dao_Empleados.getLogin(request.getParameter("auxCorreo")));
      out.write("\" name=\"idempleado\">\n");
      out.write("                <h6 class=\"text-center\">");
      out.print(request.getParameter("auxCorreo"));
      out.write("</h6>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                            <div class=\"input-group-text\"><i style=\"opacity: 0\">*</i><img src=\"imagenes/user.png\" style=\"width: 16px; height: 16px\"><i style=\"opacity: 0\">*</i></div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" name=\"user\" class=\"form-control\" placeholder=\"Usuario [dejar en blanco para no cambiar]\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                            <div class=\"input-group-text\">*<img src=\"imagenes/pass.png\" style=\"width: 16px; height: 16px\"><i style=\"opacity: 0\">*</i></div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"password\" name=\"contra\" class=\"form-control\" placeholder=\"Contraseña\" required>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" name=\"cambiar\" value=\"Recuperar Cuenta\" class=\"btn btn-secondary\">\n");
      out.write("                    <input type=\"button\" onclick=\"location.href = 'Login.jsp'\" value=\"cancelar\" class=\"btn btn-secondary\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

        } else {
      out.write("\n");
      out.write("        <div class=\"container rounded centrar\" style=\"background-color: #fff; border: 1px solid black;\">\n");
      out.write("            <h3 class=\"text-center\">Introduzca el codigo que fue enviado</h3>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"Login.jsp\" method=\"post\" name=\"nuevo\">\n");
      out.write("                <input type=\"hidden\" name=\"auxCodigo\" value=\"");
      out.print(codigo);
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"auxCorreo\" value=\"");
      out.print(request.getParameter("auxCorreo"));
      out.write("\">\n");
      out.write("                <div class=\"input-group mb-3\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                            <div class=\"input-group-text\"><img src=\"imagenes/icons8-safe-ok-48.png\" style=\"width: 16px; height: 16px\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"inputCodigo\" placeholder=\"Codigo\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" name=\"validarCodigo\" value=\"Recuperar Cuenta\" class=\"btn btn-secondary\">\n");
      out.write("                    <input type=\"button\" onclick=\"location.href = 'Login.jsp'\" value=\"cancelar\" class=\"btn btn-secondary\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");
}}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
