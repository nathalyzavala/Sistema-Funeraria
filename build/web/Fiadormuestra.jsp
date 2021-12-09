

<%@page import="modelo.entidades.Cliente"%>
<%@page import="modelo.entidades.Fiador"%>
<%@page import="modelo.dao.dao_fiador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            modelo.dao.dao_fiador fiador = new dao_fiador();
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de fiadores</title>
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
                max-height: 410px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
            }
            .tabla_modal{
                margin: 0 auto;
                display: block;
                max-height: 170px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
            }

        </style>
    </head>
    <script>
        function enviar() {
           
                document.formtabla.action = "FiadorEdit.jsp";
        }
    </script>
    <body class="bg-light text-dark">


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
                            <a class="dropdown-item" href="empleados.jsp">Cargo (Agregar, Lista)</a>
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
                            <a class="dropdown-item" href="Fiadormuestra.jsp">Acerca de...</a>
                        </div>

                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Login.jsp">Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </nav>


        <h1 class="text-center">Lista de fiadores</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <form name="formtabla" action="Fiadormuestra.jsp" method="post" id="formulario">
                <div class="table-wrapper-scroll-y">
                    <table class="table table-hover" >
                        <thead class="thead-dark text-center">
                            <tr>
                                <th scope="col">DUI</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Cliente</th>
                                <th scope="col" colspan="2">Acción</th>
                            </tr>
                        <tbody class="text-center">
                            <% for (Fiador registro : fiador.MostrarFiador()) {%>
                            <tr>
                                <td><%=registro.getDui()%></td>
                                <td><%=registro.getNombre()%></td>
                                <td><%=registro.getDireccion()%></td>
                                <td><%=registro.getTelefono()%></td>
                                <td><%=registro.getNombrecliente()%></td>
                                <td><button type="submit" value="<%=registro.getIdfiador()%>" class="btn btn-primary" onclick="enviar()" name="btneditar">Editar</button>&nbsp;&nbsp;&nbsp;<button type="submit" value="<%=registro.getIdfiador()%>"  class="btn btn-primary" name="borrar">Eliminar</button></td>
                                
                            </tr>
                            <%}%>
                    </table>
                    </div>
            </form>
    </div>

                    
                     <!--Elimnar-->
                   
        <div class="modal fade" id="eliminarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmación</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="tabla_modal">
                            <h4 class="text-center">¿Seguro de eliminar este registro?</h4>
                            
                        </div>

                    </div>
                    <div class="modal-footer">
                        <form action="ServletFiador" method="post" name="eliminarForm">
                            <center><button type="submit" name="eliminarRegistro" class="btn btn-primary" value="<%=(request.getParameter("borrar")!=null) ? request.getParameter("borrar") : ""%>">Eliminar</button></center>
                                </form>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
                                
                                
                                <%

            if (request.getParameter("borrar") != null) {
                
        %>   
        <script>
            $("#eliminarModal").modal();
        </script>
        <%}%>
</body>
</html>
