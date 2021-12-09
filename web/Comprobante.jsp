

<%@page import="dao.Dao_Venta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JasperViewer" %>
<%@page import="javax.servlet.ServletResponse" %>
<%@page import="conexion.Conexion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        
        
        <%

            out.print("<a href='detalleVenta.jsp' target='_blank' id='abrir'>afdaf</a><script>document.getElementById('abrir').click();</script>");
            
            Conexion conexion = new Conexion();
            File reportfile = new File(application.getRealPath("reportes/Reporte10.jasper"));
            Map<String, Object> parameter = new HashMap<String, Object>();
            String id = request.getParameter("registrarVenta");

            parameter.put("id", id);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, conexion.getConexion());
            response.setContentType("application/pdf");
            response.setContentLengthLong(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);
            outputstream.flush();
            outputstream.close();

            if (request.getParameter("registrarVenta") != null) {
                String[] registrar = request.getParameterValues("agregado");

                boolean venta = true;

            if (registrar != null) {
                    for (String string : registrar) {
                        if (!Dao_Venta.actualizarVenta(string)) {
                            venta = false;
                        }
                    }
                }

            }

        %>



    </body>
</html>
