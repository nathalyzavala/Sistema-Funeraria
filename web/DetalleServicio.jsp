
<%@page import="modelodao.DaoServicio"%>
<%@page import="modeloentidad.producto"%>
<%@page import="modelodao.DaoProducto"%>
<%@page import="java.util.ArrayList"%>

<%@page import="modeloentidad.servicio"%>
<%@page import="modelodao.DaoDetalleServicio"%>
<%@page import="modeloentidad.DetalleServ"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% modelodao.DaoDetalleServicio detalles = new DaoDetalleServicio();
        modelodao.DaoProducto produ = new DaoProducto();
        modelodao.DaoServicio daoSer = new DaoServicio();
        DetalleServ modificar = (DetalleServ) request.getAttribute("modificar");
    %>
    <head>
        <title>Detalles del servicio</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>
            .divScroll{
                display: block;
                max-height: 480px;
                overflow-y: auto;
            }

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
                max-height: 170px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
                width: 70%;
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
    </head>
    <script>

        function validar_desplegable() {

            if (document.formu.cantidad <= 0) {
                alert("Cantidad de Productos debe Ser mayor a Cero");
                document.formu.cantidad.focus();
                return false;
            }
        }
        ;
        function escogerServicio() {
            if (document.servicios.serviciotabla.selectedIndex == 0) {
                alert("Debe seleccionar un Servicio para mostrar .");
                document.formu.serviciosd.focus();
                return 0;
            } else {
                document.servicios.submit();
            }
        }
        ;
        function producto() {

        }
        function limpiar() {
            location.reload();
        }
        ;
        function seleccion() {
            document.getElementById("serv").options.item(0).selected = 'selected';
            escogerServicio();
        }
        ;

        function validacionNumber() {
            document.formu.action = "DetalleServicio.jsp";
            document.formu.submit();
        }
        ;

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


        <h1 class="text-center">Registro de droductos de servicios</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <div class="row"> 
                <div class="col">

                    <form action="DetalleServicioServlet" method="post" name="formu">

                        <%
                            servicio auxDetalle = null;

                            int auxServicio = -1;
                            int auxProducto = -1;

                            if (request.getParameter("serviciotabla") != null) {
                                auxDetalle = daoSer.getServicios(request.getParameter("serviciotabla"));
                            }

                            if (request.getParameter("productosd") != null) {
                                auxProducto = Integer.parseInt(request.getParameter("productosd"));
                            }

                            if (request.getParameter("serviciosd") != null) {
                                auxServicio = Integer.parseInt(request.getParameter("serviciosd"));
                            }

                        %>
                        <div>
                            <label>Seleccionar Servicio:</label>
                            <select name="serviciosd"  onchange="validacionNumber()" required class="form-control">
                                <%for (servicio detalle : detalles.getServicios()) {
                                %>
                                <option value="<%=detalle.getId_servicio()%>" <%= (modificar != null) ? ((modificar.getId_servicio() == detalle.getId_servicio()) ? "selected" : "") : (auxServicio == detalle.getId_servicio()) ? "selected" : ""%> ><%=detalle.getNombreServicio()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <input type="hidden"   name="id" value="<%=(modificar == null) ? "" : modificar.getId_detalleservicio()%>" >
                        </div>

                </div>
                <div class="col">
                    <div >
                        <label>Seleccionar Producto:</label>
                        <select name="productosd" required onchange="validacionNumber()" class="form-control">
                            <%
                                for (producto detalle : produ.getProductoP()) {
                            %>
                            <option value="<%=detalle.getIdproducto()%>"<%= (modificar != null) ? ((modificar.getId_producto() == detalle.getIdproducto()) ? "selected" : "") : (auxProducto == detalle.getIdproducto()) ? "selected" : ""%> ><%=detalle.getNombrproducto()%></option>
                            <%
                                }
                            %>

                        </select>
                    </div>
                </div>
                <div class="col">
                    <div>
                        <% String nombreProducto = produ.getProdu(auxProducto + "").getNombrproducto();%>
                        <label for="cantidadd">Cantidad Productos:</label>
                        <input type="number" min="1" max="1000" class="form-control" value="<%=(modificar == null) ? ((nombreProducto != null) ? ((nombreProducto.toLowerCase().contains("caja funebre")) ? "1" : "") : "") : modificar.getCantidad()%>"   id="cantidadd"  name="cantidadd"  required <%=(nombreProducto != null) ? ((nombreProducto.toLowerCase().contains("caja funebre")) ? "readonly" : "") : ""%>>

                    </div> 
                </div>
            </div>
            <div class="row">
                <div class="col"><label>&nbsp;</label></div>
            </div>
            <div class="row">
                <div class="col text-right">
                    <input onclick="validar_desplegable()" class="btn btn-secondary" type="submit" value="<%=(modificar == null) ? "Registrar" : "Modificar"%>" name="<%=(modificar == null) ? "registrar" : "modificar"%>">
                </div>
                <div class="col">
                    <input onclick="limpiar()" type="submit" class="btn btn-secondary" name="cancelar" value="Cancelar">  
                </div>
            </div>
        </form>
        <div class="row">

            <div class="col">
                <label>&nbsp;</label>
                <form action="DetalleServicioServlet" method="post" id="servicios" name="servicios">
                    <div >
                        <select name="serviciotabla" onchange="escogerServicio()" class="form-control">
                            <option value="SELECCIONAR" id="serv">Seleccionar Servicio a Mostrar:</option>
                            <%
                                for (servicio detalle : detalles.getServicios()) {
                            %>
                            <option onclick="limpiar()" value="<%=detalle.getId_servicio()%>" <%= (auxDetalle != null) ? ((auxDetalle.getId_servicio() == detalle.getId_servicio()) ? "selected" : "") : ""%> ><%=detalle.getNombreServicio()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>&nbsp;</label>
                <%
                    if (auxDetalle != null) {
                %>
                <div class="table-wrapper-scroll-y">
                    <table class="table table-hover">
                        <thead class="text-center thead-dark">
                            <tr>
                                <th scope="col">Producto</th>
                                <th scope="col">Cantidad</th>
                                <th colspan="2" scope="col">Acción</th>
                            </tr>
                        </thead>

                        <tbody class="text-center ">
                            <%
                                    for (DetalleServ cl : detalles.getDetallesServiciosProductos(auxDetalle.getId_servicio())) {%>
                            <tr>
                                <td><%=cl.getProdu().getNombrproducto()%></td>
                                <td><%=cl.getCantidad()%></td>
                                <td><button type="submit"name="btneditar" class="btn btn-primary" onclick="enviar()" value="<%=cl.getId_detalleservicio()%>"  >Editar</button>&nbsp;
                                    &nbsp;&nbsp;
                                <button type="submit" name="borrar" class="btn btn-primary" onclick="enviar()"  value="<%=cl.getId_detalleservicio()%>" >Borrar</button></td>
                            </tr>
                            <%}
                                    }%>
                        </tbody>
                    </table>
                </div>
                </form>
            </div> 
        </div>
    </div>                                        
</body>
</html>