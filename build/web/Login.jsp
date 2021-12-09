

<%@page import="dao.Dao_Login"%>
<%@page import="dao.Dao_Empleados"%>
<%@page import="entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
        <link rel="icon" href="imagenes/icon.png">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>
            .centrar {
                overflow: hidden;
                position: absolute;
                width: 35%;
                top: 20%;
                left: 33%;
                padding: 20px;
            }
        </style>
    </head>


    <body class="bg-light text-dark">

        <!--Modales-->

        <!--Modal existe correo-->
        <div class="modal fade" id="modalExiste" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Código de recuperación enviado</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <h5 class="text-center">Código enviado al correo electronico</h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Modal no existe correo-->
        <div class="modal fade" id="noExiste" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              	  <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Error al enviar el código de recuperación</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5 class="text-center">No existe el correo introducido</h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.href = 'Login.jsp'">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Fin modales-->

        <%

            if (request.getParameter("recuperar") == null && request.getParameter("enviarCodigo") == null && request.getParameter("validarCodigo") == null) {
        %>
        

		
        
        <div class="container rounded centrar text-center" style="background-color: #fff; border: 1px solid black;">
        	
            <h3 class="text-center">Iniciar Sesión</h3>
            <h1 class="text-center">Funeraria la esperanza</h1>
            <div class="input-group mb-3 text-center" style="margin-left: 38%;">
            	<img src="imagenes/logoReporte.png" style="width: 25%;height: 25%;">
        	</div>
            <form action="ControladorLogin" method="post" name="login">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"><img src="imagenes/user.png"></span>
                    </div>
                    <input type="text" class="form-control" placeholder="Usuario" aria-label="Usuario" aria-describedby="basic-addon1" name="usuario" required>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"><img src="imagenes/pass.png"></span>
                    </div>
                    <input type="password" class="form-control" placeholder="Contraseña" aria-label="Contraseña" aria-describedby="basic-addon1" name="contrasena" required>
                </div>

                <div class="text-center">
                    <input type="submit" name="iniciar" value="Iniciar Sesión" class="btn btn-secondary">
                    <input type="reset" name="limpiar" value="Limpiar" class="btn btn-secondary">
                </div>
                <br>
            </form>
            <form method="post" action="Login.jsp">
                <div class="text-center">
                    <p><button type="submit" onclick="recuperarContra()" name="recuperar" class="btn btn-outline-secondary">¿No puedes iniciar sesión?</button></p>
                </div>
            </form>
        </div>
        <%} else if (request.getParameter("enviarCodigo") == null && request.getParameter("validarCodigo") == null) {%>


        <div class="container rounded centrar" style="background-color: #fff; border: 1px solid black;">
            <h3 class="text-center">Codigo para recuperar la cuenta</h3>
            <br>
            <form action="Login.jsp" method="post" name="nuevo">
                <div class="input-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><img src="imagenes/icons8-new-post-64.png" style="width: 16px; height: 16px"></div>
                        </div>
                        <input type="email" name="correo" class="form-control" placeholder="correoEmpleado@ejemplo.com" required>
                    </div>
                </div>


                <div class="text-center">
                    <input type="submit" name="enviarCodigo" value="Enviar codigo de recuperación" class="btn btn-secondary">
                    <input type="button" onclick="location.href = 'Login.jsp'" value="cancelar" class="btn btn-secondary">
                </div>
            </form>
        </div>


        <%} else if (request.getParameter("enviarCodigo") != null) {%>

        <%
            String codigo = Empleado.codigoRecuperacion();
            String email = request.getParameter("correo");
            System.out.println(email);
            boolean existeCorreo = Dao_Login.existeCorreo(email);
            if (existeCorreo) {
                if (Empleado.enviarCorreo(codigo, email)) {
        %>

        <%
            }
        } else {
        %>



        <%
            }
        %>


        <%if (existeCorreo) {%>
        <script>
            $("#modalExiste").modal();
        </script>
        <div class="container rounded centrar" style="background-color: #fff; border: 1px solid black;">
            <h3 class="text-center">Introduzca el código que fue enviado</h3>
            <br>
            <form action="Login.jsp" method="post" name="nuevo">
                <input type="hidden" name="auxCodigo" value="<%=codigo%>">
                <input type="hidden" name="auxCorreo" value="<%=request.getParameter("correo")%>">
                <div class="input-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><img src="imagenes/icons8-safe-ok-48.png" style="width: 16px; height: 16px"></div>
                        </div>
                        <input type="text" class="form-control" name="inputCodigo" placeholder="Código">
                    </div>
                </div>


                <div class="text-center">
                    <input type="submit" name="validarCodigo" value="Recuperar Cuenta" class="btn btn-secondary">
                    <input type="button" onclick="location.href = 'Login.jsp'" value="cancelar" class="btn btn-secondary">
                </div>
            </form>
        </div>
        <%} else {
        %>
        <script>
            $("#noExiste").modal();
        </script>
        <%
            }%>
        <%} else {
            String codigo = request.getParameter("auxCodigo");
            String input = request.getParameter("inputCodigo");
            if (codigo.equals(input)) {

        %>

        <div class="container rounded centrar" style="background-color: #fff; border: 1px solid black;">
            <h3 class="text-center">Cambio de credenciales de inicio</h3>
            <br>
            <form action="ControladorLogin" method="post" name="nuevo">
                <input type="hidden" value="<%=Dao_Empleados.getLogin(request.getParameter("auxCorreo"))%>" name="idempleado">
                <h6 class="text-center"><%=request.getParameter("auxCorreo")%></h6>
                <br>
                <div class="input-group mb-3">
                    <div class="input-group">

                        <div class="input-group-prepend">
                            <div class="input-group-text"><i style="opacity: 0">*</i><img src="imagenes/user.png" style="width: 16px; height: 16px"><i style="opacity: 0">*</i></div>
                        </div>
                        <input type="text" name="user" class="form-control" placeholder="Usuario [dejar en blanco para no cambiar]">
                    </div>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">*<img src="imagenes/pass.png" style="width: 16px; height: 16px"><i style="opacity: 0">*</i></div>
                        </div>
                        <input type="password" name="contra" class="form-control" placeholder="Contraseña" required>
                    </div>
                </div>

                <div class="text-center">
                    <input type="submit" name="cambiar" value="Recuperar Cuenta" class="btn btn-secondary">
                    <input type="button" onclick="location.href = 'Login.jsp'" value="cancelar" class="btn btn-secondary">
                </div>
            </form>
        </div>

        <%
        } else {%>
        <div class="container rounded centrar" style="background-color: #fff; border: 1px solid black;">
            <h3 class="text-center">Introduzca el codigo que fue enviado</h3>
            <br>
            <form action="Login.jsp" method="post" name="nuevo">
                <input type="hidden" name="auxCodigo" value="<%=codigo%>">
                <input type="hidden" name="auxCorreo" value="<%=request.getParameter("auxCorreo")%>">
                <div class="input-group mb-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text"><img src="imagenes/icons8-safe-ok-48.png" style="width: 16px; height: 16px"></div>
                        </div>
                        <input type="text" class="form-control" name="inputCodigo" placeholder="Codigo">
                    </div>
                </div>


                <div class="text-center">
                    <input type="submit" name="validarCodigo" value="Recuperar Cuenta" class="btn btn-secondary">
                    <input type="button" onclick="location.href = 'Login.jsp'" value="cancelar" class="btn btn-secondary">
                </div>
            </form>
        </div>
        <%}}%>



    </body>
</html>
