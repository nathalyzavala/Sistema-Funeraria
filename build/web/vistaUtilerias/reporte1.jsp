<%-- 
    Document   : reporte1
    Created on : 12-10-2018, 09:03:13 PM
    Author     : dell
--%>

<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% 
         Conexion conexion = new Conexion();        
         File reportFile = new File(application.getRealPath("reportes/Reporte1.jasper")); 
         Map<String, Object> parameter = new HashMap<String,Object>();
         byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameter, conexion.getConexion()); 
         response.setContentType("application/pdf");
         response.setContentLength(bytes.length); 
         ServletOutputStream ouputStream = response.getOutputStream(); 
         ouputStream.write(bytes, 0, bytes.length);
         ouputStream.flush(); 
         ouputStream.close(); 
         %>
    
    </body>
</html>
