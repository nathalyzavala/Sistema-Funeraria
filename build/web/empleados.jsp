

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.Cargo"%>
<%@page import="dao.Dao_Cargos"%>
<%@page import="entidades.Empleado"%>
<%@page import="dao.Dao_Empleados"%>
<%@page import="dao.Dao_Clientes"%>
<%@page import="modelo.dao.Dao_clientes"%>
<%@page import="modelo.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% dao.Dao_Empleados empleado = new Dao_Empleados();%>
    <%  Empleado modificar = (Empleado) request.getAttribute("modificar");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
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
                if (confirm('¿Desea eliminar empleado?')) {
                    document.tuformulario.submit();
                }
            }
            ;

            function validateDui() {
                if (!$('input').is('[readonly]')) {
                    if (document.getElementById("dui").value != "") {
                        document.getElementById('form').action = 'empleados.jsp';
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

        <%
            Empleado validacion = null;

            if (request.getParameter("dui") != null) {
                validacion = new Empleado();
                if (Dao_Empleados.validarDui(request.getParameter("dui"))) {

                    validacion.setDui("");
                } else {
                    validacion.setDui(request.getParameter("dui"));
                }

                validacion.setNombre(request.getParameter("nombre"));
                validacion.setApellidos(request.getParameter("apellido"));

                validacion.setTelefono(request.getParameter("telefono"));
                validacion.setDirecion(request.getParameter("direccion"));
                validacion.getCargo().setId(Integer.parseInt(request.getParameter("cargo")));

                validacion.setFechaNacimiento(request.getParameter("fechaNacimiento"));
                validacion.setFechaContrato(request.getParameter("fechaContrato"));
            }

            if (request.getParameter("registrarl") != null || request.getParameter("modificarl") != null) {
                validacion = null;
            }

        %>


        <h1 class="text-center"><%=(modificar == null) ? "Nuevo" : "Editar"%> Empleado</h1>

        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white;">

            <form action="servletempleado" method="post" id="form">




                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="" class="form-check-label">DUI</label>
                            <input type="text" maxlength="10" id="dui" onblur="validateDui()" name="dui" pattern="^[0-9]{8}-[0-9]{1}$" class="form-control" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getDui()) : modificar.getDui()%>" placeholder="12345678-9" required <%=(modificar == null) ? "" : "readonly"%>/>
                            <input type="hidden" name="idEmpleado" value="<%=(modificar == null) ? "" : modificar.getId()%>">
                        </div>
                    </div>
                    <div class="col"></div>
                </div>






                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="" class="form-check-label">Nombre</label>
                            <input type="text" maxlength="50" class="form-control" name="nombre" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getNombre()) : modificar.getNombre()%>" placeholder="Ej: Alex Antonio" required/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="" class="form-check-label">Apellido </label></td>
                            <input type="text" maxlength="50" class="form-control" name="apellido" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getApellidos()) : modificar.getApellidos()%>" placeholder="Ej: Fuentes Cruz" required/>
                        </div>
                    </div>
                </div>




                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="" class="form-check-label">Teléfono </label>
                            <input type="tel" maxlength="9" id="telefono" class="form-control" name="telefono" pattern="^[0-9]{4}-[0-9]{4}$" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getTelefono()) : modificar.getTelefono()%>" placeholder="Ej: 7513-2342" required/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="" class="form-check-label">Dirección </label></td>
                            <textarea maxlength="100" name="direccion"  class="form-control" placeholder="Ej: Primera avenida..." required><%=(modificar == null) ? ((validacion == null) ? "" : validacion.getDirecion()) : modificar.getDirecion()%></textarea>  
                        </div>
                    </div>
                </div>



                <div class="row">
                    <%

                    %>
                    <div class="col">
                        <div class="form-group">
                            <label class="form-control-label">Fecha Nacimiento</label>
                            <input type="date" name="fechaNacimiento" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getFechaNacimiento()) : modificar.getFechaNacimiento()%>" class="form-control" required>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label class="form-control-label">Fecha Contrato</label>
                            <input type="date" name="fechaContrato" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getFechaContrato()) : modificar.getFechaContrato()%>" class="form-control" required <%=(modificar == null) ? "" : "readonly"%>>
                        </div>

                    </div>
                </div>


                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label class="form-control-label">Correo electronico</label>
                            <input type="email" maxlength="100" class="form-control" name="correo" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getCorreo()) : modificar.getCorreo()%>" placeholder="correo@ejemplo.com" required>
                            <div class="invalid-tooltip">
                                Formato incorrecto de correo
                            </div>
                        </div>
                    </div>


                    <div class="col">
                        <div class="form-group">
                            <label>Cargo</label>
                            <select name="cargo" class="form-control">
                                <%
                                    if (Dao_Cargos.getCargos() != null) {
                                        for (Cargo cargo : Dao_Cargos.getCargos()) {
                                            if (!cargo.getNombre().equals("Gerente")) {
                                %>

                                <option value="<%=cargo.getId()%>"><%=cargo.getNombre()%></option>

                                <%
                                            }
                                        }
                                    }
                                %>
                            </select>
                        </div>

                    </div>  

                </div>

                <br>

                <div class="row">
                    <div class="col text-center">  <input type="submit" class="btn btn-secondary" onclick="validardui()"  
                                                          value="<%=(modificar == null) ? "Guardar" : "Modificar"%>"
                                                          name="<%=(modificar == null) ? "registrarl" : "modificarl"%>" />&nbsp;&nbsp;&nbsp;
                        <input type="button" onclick="location.href = 'empleados.jsp'" class="submint btn btn-secondary" value="Cancelar"></div>
                </div>



            </form>
            <br>
            <form action="servletempleado" method="post">
                <div class="table-wrapper-scroll-y" style="width: 97%;">
                    <table class="table table-hover" style="font-size: 14px">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">DUI</th>
                                <th scope="col">Nombre Completo</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Cargo</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Edad</th>
                                <th scope="col">Fecha Contrato</th>
                                <th scope="col">Acción</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                    for (Empleado cli : empleado.getEmpleados()) {%>
                            <tr>
                                <td><%=cli.getDui()%></td>
                                <td><%=cli.getNombre()%> <%=cli.getApellidos()%></td>
                                <td><%=cli.getTelefono()%></td>
                                <td><%=cli.getDirecion()%></td>
                                <td><%=cli.getCargo().getNombre()%></td>
                                <td><%=cli.getCorreo()%></td>
                                <td><%
                                    Date fechaA = new Date();
                                    SimpleDateFormat formato = new SimpleDateFormat("yyyy");
                                    int anioA = Integer.parseInt(formato.format(fechaA));

                                    String fechaNacimiento = cli.getFechaNacimiento();
                                    Date auxFecha = formato.parse(fechaNacimiento);
                                    int anioN = Integer.parseInt(formato.format(auxFecha));

                                    out.print(anioA - anioN);

                                    %></td>
                                <td><%=cli.getFechaContrato()%></td>
                                <td>
                                    <button class="btn btn-primary readMore roundBtn" name="btneditarl" value="<%=cli.getId()%>">Editar</button>
                                    <%if (!cli.getCargo().getNombre().equals("Vendedor")) {%>
                                    <button type="submit" class="btn btn-primary readMore roundBtn" name="borrarl" onclick="pregunta()" value="<%=cli.getId()%>">Borrar</button>
                                    <%}%>

                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>
