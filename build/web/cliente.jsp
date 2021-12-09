

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
        <title>Clientes</title>
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
                            <a class="dropdown-item" href="Fiadormuestra.jsp">Acerca de...</a>
                        </div>

                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Login.jsp">Cerrar Sesión</a>
                    </li>
                    
                </ul>
            </div>
        </nav>
        
        <h1 class="text-center"><%=(modificar == null) ? "Nuevo" : "Editar"%> Cliente</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white;">
            <form action="Servletcliente" method="post" id="form">

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">DUI: </label>
                            <input type="text" maxlength="10" id="dui"  class="form-control" onblur="validateDui()" name="dui" pattern="^[0-9]{8}-[0-9]{1}$" class="input" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getDuic()) : modificar.getDuic()%>" placeholder="12345678-9" required <%=(modificar == null) ? "" : "readonly"%>/>
                        </div>
                    </div>
                    <div class="col"></div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Nombre </label>
                            <input type="text" maxlength="50" name="nombre" class="form-control" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getNombrec()) : modificar.getNombrec()%>" placeholder="Ej: Alex Antonio" required/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Apellido </label>
                            <input type="text" maxlength="50" name="apellido" class="form-control" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getApellidoc()) : modificar.getApellidoc()%>" placeholder="Ej: Fuentes Cruz" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Teléfono </label></td>
                        <input type="tel" id="telefono" maxlength="9" id="telefono" name="telefono" class="form-control" pattern="^[0-9]{4}-[0-9]{4}$" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getTelefono()) : modificar.getTelefono()%>" placeholder="Ej: 7513-2342" required/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Dirección </label>
                            <textarea maxlength="100" name="direccion"  class="form-control" placeholder="Ej: Primera avenida..." required><%=(modificar == null) ? ((validacion == null) ? "" : validacion.getDireccionc()) : modificar.getDireccionc()%></textarea>  
                        </div>
                    </div>
                </div>

                <div class="row" >
                    
                    <div class="col text-center">  
                        <input type="hidden" name="idemple" value="<%=(modificar == null) ? "" : modificar.getId_cliente()%>"/>
                        <input type="submit" class="btn btn-secondary" onclick="validardui()"  
                                                          value="<%=(modificar == null) ? "Guardar" : "Modificar"%>"
                                                          name="<%=(modificar == null) ? "registrarl" : "modificarl"%>" />&nbsp;&nbsp;&nbsp;
                        <input type="button" onclick="location.href = 'cliente.jsp'" value="Cancelar" class="submint btn btn-secondary readMore roundBtn">
                    </div>
                </div>



            </form>

            <form action="Servletcliente" method="post">
                <div class="table-wrapper-scroll-y" style="width: 97%;">
                    <table class="table table-hover" style="font-size: 14px">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">DUI</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Acción</th>
                            </tr>
                        </thead>
                        <br></br>
                        <tbody>
                            <%
                        for (Clientes cli : cliente.getClintes()) {%>
                            <tr>
                                <td><%=cli.getDuic()%></td>
                                <td><%=cli.getNombrec()%></td>
                                <td><%=cli.getApellidoc()%></td>
                                <td><%=cli.getTelefono()%></td>
                                <td><%=cli.getDireccionc()%></td>
                                <td><div align="right">
                                        <button class="btn btn-primary readMore roundBtn" name="btneditarl" value="<%=cli.getId_cliente()%>">Editar</button>
                                        <%if (!Dao_Clientes.clienteCompraRealizada(cli.getId_cliente())) {%>
                                        <button type="submit" class="btn btn-primary readMore roundBtn" name="borrarl" onclick="pregunta()" value="<%=cli.getId_cliente()%>">Borrar</button>
                                        <%}%>
                                    </div>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
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
    </body>
</html>
