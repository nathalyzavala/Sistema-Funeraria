

<%@page import="entidades.DetalleServicio"%>
<%@page import="entidades.Servicio"%>
<%@page import="dao.Dao_Servicios"%>
<%@page import="entidades.DetalleVenta"%>
<%@page import="dao.Dao_Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Ventas</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
            <script src="js/bootbox.min.js"></script>
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
        function escogerServicio() {
            document.getElementById("venta").submit();
        }
        ;
        
        function ircuota() {
                document.form.action = "cuotas.jsp";
                document.form.submit();
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

        
        <h1 class="text-center">Listado de ventas</h1>
        <div class="container rounded" style="border: 1px solid black; padding: 20px; background-color: white;">
            <div class="row">
                <div class="col">
                    <input type="text" id="buscar" onkeyup="buscarTabla()" placeholder="Buscar po DUI" class="form-control">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col">
                    <div class="table-wrapper-scroll-y">
                        <form method="post" action="listaVentas.jsp" name="form">
                            <table class="table table-hover" id="tabla" style="font-size: 13px;">
                                <thead class="thead-dark text-center">
                                    <th scope="col">Fecha Venta</th>
                                    <th scope="col">DUI</th>
                                    <th scope="col">Nombre Cliente</th>
                                    <th scope="col">Servicio</th>
                                    <th scope="col">Costo Servicio</th>
                                    <th scope="col">Cantidad Cuotas</th>
                                    <th scope="col">Costo Cuota</th>
                                    <th scope="col">Devolución</th>                              
                                    <th scope="col" colspan="2">Acción</th>
                                </thead>
                                <tbody class="text-center">
                                    <%
                                        if (Dao_Venta.getVentas() != null) {
                                            for (DetalleVenta detalle : Dao_Venta.getVentas()) {
                                    %>            
                                    <tr>
                                        <td>
                                            <%=detalle.getEncabezado().getFecha()%>
                                        </td>
                                        <td>
                                            <%=detalle.getEncabezado().getCliente().getDui()%>
                                        </td>
                                        <td>
                                            <%=detalle.getEncabezado().getCliente().getNombre()%> <%=detalle.getEncabezado().getCliente().getApellidos()%>
                                        </td>
                                        <td>
                                            <%=detalle.getServicio().getNombre()%>
                                        </td>
                                        <td>
                                            $<%=detalle.getServicio().getCosto()%>
                                        </td>
                                        <td>
                                            <%=(detalle.getCantidadCuotas()==1)?"Contado":detalle.getCantidadCuotas()%>
                                        </td>
                                        <td>
                                            $<%=(detalle.getCantidadCuotas() > 0) ? String.format("%.2f", (detalle.getServicio().getCosto() / detalle.getCantidadCuotas())) : "0"%>
                                        </td>
                                        <td>
                                            <%
                                                System.out.println(detalle.getEncabezado().getCliente().getNombre() + "" + detalle.isDevolucion());
                                            if(detalle.isDevolucion()){
                                                out.print("Devuelto");
                                            }else{
                                                %>
                                            <button type="submit" class="btn btn-primary" name="abrirDevolucion" value="<%=detalle.getId()%>-<%=detalle.getServicio().getId()%>" style="font-size : 13px;">
                                                Devolver
                                            </button>
                                            <%
                                            }
                                            %>
                                        </td>
                                        
                                        <td>
                                            <button type="submit" class="btn btn-primary" name="abrir" value="<%=detalle.getId()%>" style="font-size: 13px">
                                                Ver
                                            </button>
                                        </td>
                                        <td>
                                            <button type="submit" name="eliminar" class="btn btn-primary" value="<%=detalle.getId()%>" style="font-size: 13px">Eliminar</button>
                                        </td>
                                    </tr>  
                                    <%}
                                }%>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!--ver-->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Detalles del servicio comprado</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="tabla_modal">
                            <table class="table table-hover">
                                <thead class="thead-dark">
                                <th scope="col">Nombre</th>
                                <th scope="col">Cantidad</th>
                                </thead>
                                <tbody>
                                    <%
                                        
                                        String id = "";
                                        if (request.getParameter("abrir") != null) {
                                            
                                            id = (request.getParameter("abrir"));
                                            
                                            for (DetalleServicio detalle : Dao_Servicios.getVenta(Integer.parseInt(id))) {
                                    %>            
                                    <tr>
                                        <td>
                                            <%=detalle.getProducto().getNombre()%>
                                        </td>
                                        <td>
                                            <%=detalle.getCantidad()%>
                                        </td>
                                    </tr>  
                                    <%}
                                        }%>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <form action="cuotas.jsp" method="post">
                                    <center><button type="submit" name="vercuotas" class="btn btn-primary" value="<%=id%>">Ver Pagos</button></center>
                                </form>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
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
                        <form action="ControladorVenta" method="post" name="eliminarForm">
                            <center><button type="submit" name="eliminarRegistro" class="btn btn-primary" value="<%=(request.getParameter("eliminar")!=null) ? request.getParameter("eliminar") : ""%>">Eliminar</button></center>
                                </form>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
                                
        <!--Devoluciones-->
                   
        <div class="modal fade" id="devolucionesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                            <h4 class="text-center">¿Se han devuelto todos los articulos?</h4>
                            
                        </div>

                    </div>
                    <div class="modal-footer">
                        <form action="ControladorVenta" method="post" name="eliminarForm">
                            <center><button type="submit" name="devolver" class="btn btn-primary" value="<%=request.getParameter("abrirDevolucion")%>">Devolver</button></center>
                                </form>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
                                
        <%

            if (request.getParameter("abrirDevolucion") != null) {
        %>   
        <script>
            $("#devolucionesModal").modal();
        </script>
        <%}%>
        
        <%

            if (request.getParameter("abrir") != null) {
        %>   
        <script>
            $("#exampleModal").modal();
        </script>
        <%}%>
        
        <%

            if (request.getParameter("eliminar") != null) {
        %>   
        <script>
            $("#eliminarModal").modal();
        </script>
        <%}%>
        

        <script>
            function buscarTabla() {
                
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("buscar");
                filter = input.value.toUpperCase();
                table = document.getElementById("tabla");
                tr = table.getElementsByTagName("tr");

                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>

    </body>
</html>
