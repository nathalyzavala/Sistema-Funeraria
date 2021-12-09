

<%@page import="dao.Dao_Clientes"%>
<%@page import="modelo.dao.Dao_clientes"%>
<%@page import="modelo.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% modelo.dao.Dao_clientes cliente = new Dao_clientes();%>
    <%  Clientes modificar = (Clientes) request.getAttribute("modificar");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acerca de</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>
            table thead {
                position: -webkit-sticky;
                position: sticky;
                top: 0;
                z-index: 5;
                background: #fff;
            }
            .table-wrapper-scroll-y {

                margin: 0 auto;
                display: block;
                max-height: 350px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
            }

            .divScroll{
                display: block;
                max-height: 480px;
                overflow-y: auto;
            }

            .registro{
                display: block;
                max-height: 430px;
                overflow-y: auto;
            }


        </style>
        <script language="JavaScript">
            function pregunta() {
                if (confirm('¿Desea eliminar cliente?')) {
                    document.tuformulario.submit();
                }
            }
            ;
            function validateDui() {
                if (!$('input').is('[readonly]')) {
                    if (document.getElementById("dui").value != "") {
                        document.getElementById('form').action = 'cliente.jsp';
                        document.getElementById('form').submit();
                    }
                }
            }
        </script>
        <script>
            $(document).ready(Telefono);
            $(document).ready(Dui);
            function Telefono() {
                var flag1 = true;
                $(document).on('keyup', '[id=telefono]', function (e) {
                    if ($(this).val().length == 4 && flag1) {
                        $(this).val($(this).val() + "-");
                        flag1 = false;
                    }
                });
            }
            function Dui() {
                var flag1 = true;
                $(document).on('keyup', '[id=dui]', function (e) {
                    if ($(this).val().length == 8 && flag1) {
                        $(this).val($(this).val() + "-");
                        flag1 = false;
                    }
                });
            }
        </script>
    </head>
    <body class="bg-light text-dark">

        <%
            Clientes validacion = null;

            if (request.getParameter("dui") != null) {
                validacion = new Clientes();
                if (!Dao_clientes.validarDui(request.getParameter("dui"))) {

                    validacion.setDuic(request.getParameter("dui"));
                } else {
                    validacion.setDuic("");
                }

                validacion.setNombrec(request.getParameter("nombre"));
                validacion.setApellidoc(request.getParameter("apellido"));

                validacion.setTelefono(request.getParameter("telefono"));
                validacion.setDireccionc(request.getParameter("direccion"));
            }

            if (request.getParameter("registrarl") != null || request.getParameter("modificar1") != null) {
                validacion = null;
            }

        %>

 <nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
            <a class="navbar-brand" href="#">Funeraria</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExample09">
                <ul class="navbar-nav mr-auto">
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ventas</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="detalleVenta.jsp">Realizar Venta</a>
                            <a class="dropdown-item" href="listaVentas.jsp">Lista Ventas</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Servicios</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="Servicios.jsp">Servicios (Agregar, Lista)</a>
                            <a class="dropdown-item" href="DetalleServicio.jsp">Detalles de servicios</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Productos</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="Productos.jsp">Productos (Agregar, Lista)</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Empleados</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="empleados.jsp">Empleados (Agregar, Lista)</a>
                            <a class="dropdown-item" href="cargo.jsp">Cargo (Agregar, Lista)</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Clientes</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="cliente.jsp">Clientes (Agregar, Lista)</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Fiadores</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09"> 
                            <a class="dropdown-item" href="FiadorRegistro.jsp">Agregar</a>
                            <a class="dropdown-item" href="Fiadormuestra.jsp">Lista</a>
                        </div>

                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reportes</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="vistaUtilerias/reporte1.jsp">Reporte Empleados</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte2.jsp">Reporte Clientes</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte3.jsp">Reporte Detalles de Servicios</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte4.jsp">Reporte Clientes y Fiadores</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte5.jsp">Reporte Clientes Pago Contado</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte6.jsp">Reporte Clientes Pago Cuota</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte7.jsp">Reporte Cantidad Servicio Vendidos</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte8.jsp">Reporte de Empledos Con mas Ventas Registradas</a>
                            <a class="dropdown-item" href="vistaUtilerias/reporte9.jsp">Reporte Ventas por Servicios</a>
                            
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ayuda</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09"> 
                            <a class="dropdown-item" href="Manual de usuario.pdf" target="_blank">Documentación</a>
                            <a class="dropdown-item" href="acercade.jsp">Acerca de...</a>
                        </div>

                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Login.jsp">Cerrar Sesión</a>
                    </li>
                    
                </ul>
            </div>
        </nav>
        
        <h1 class="text-center">Acerca de</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white;">
            <center><img src="imagenes/logoReporte.png" style="width: 25%;height: 25%"></center><br>
            <p class="text-center">Este es el sistema web de ventas de la <strong>Funeraria la Esperanza</strong></p>
            <p class="text-center">Brindamos los mejores servicios funerarios para ese momento de dolorosos de tu vida, te acompañamos hasta el final</p>
        </div>
    </body>
</html>
