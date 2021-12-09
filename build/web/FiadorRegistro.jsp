

<%@page import="modelo.entidades.Cliente"%>
<%@page import="modelo.entidades.Fiador"%>
<%@page import="modelo.dao.dao_fiador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        modelo.dao.dao_fiador fiador = new dao_fiador();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de fiador</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <script>
            function validateDui() {
                
                    if (document.getElementById("dui").value != "") {
                        document.getElementById('form').action = 'FiadorRegistro.jsp';
                        document.getElementById('form').submit();
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
    <body>
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
        <%
            Fiador validacion = null;
            if (request.getParameter("dui") != null) {
                validacion = new Fiador();
                if (dao_fiador.validarDui(request.getParameter("dui"))) {
                    validacion.setDui("");
                } else {
                    validacion.setDui(request.getParameter("dui"));
                }

                validacion.setNombre(request.getParameter("nombre"));
                validacion.setDireccion(request.getParameter("apellido"));

                validacion.setTelefono(request.getParameter("telefono"));
            }

        %>

        <h1 class="text-center">
            Registro de Fiador
        </h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <form name="registro" action="ServletFiador" id="form" method="post">
                <div class="form-row">
                    <div class="col">
                        <label>DUI:</label>
                        <input type="text" maxlength="10" onblur="validateDui()" pattern="[0-9]{8}-[0-9]{1}" name="dui" id="dui" value="<%=((validacion == null) ? "" : validacion.getDui())%>" class="form-control" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col">
                        <label>Nombre:</label>
                        <input type="text" maxlength="100" name="nombre" value="<%=((validacion == null) ? "" : validacion.getNombre())%>" class="form-control" required>
                    </div>
                    <div class="col">
                        <label>Teléfono:</label>
                        <input type="text" maxlength="9" onkeypress=" varchar" pattern="[0-9]{4}-[0-9]{4}" class="form-control" value="<%=((validacion == null) ? "" : validacion.getTelefono())%>" name="telefono" id="telefono" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="col">
                        <label>Dirección:</label>
                        <textarea maxlength="100" name="direccion"  class="form-control" required><%=((validacion == null) ? "" : validacion.getNombre())%></textarea>
                    </div>
                    <div class="col">
                        <label>Cliente:</label>
                        <select name="cliente" class="form-control">
                            <% for (Cliente registro : fiador.MostrarCliente()) {%>
                            <option selected value="<%= registro.getIdcliente()%>"><%= registro.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>       
                <br>
                <div class="form-row">
                    <div class="col text-right">
                        <input type="submit" name="insertar" value="Insertar" class="btn btn-secondary">
                    </div>
                    <div class="col">
                        <input type="submit" name="cancelarRegistro" value="cancelar" class="btn btn-secondary">
                    </div>
                </div>


            </form>
        </div>
    </body>
</html>
