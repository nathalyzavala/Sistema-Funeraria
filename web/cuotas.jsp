


<%@page import="dao.Dao_Venta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.PagoCuotas"%>
<%@page import="dao.dao_cuotas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        dao.dao_cuotas cuotas = new dao_cuotas();
        dao.Dao_Venta ventas = new Dao_Venta();

        String id = "";

        if (request.getParameter("pagar") != null) {
            if (!new dao_cuotas().setRegistrar(request.getParameter("sql"))) {
    %>

    <script>
        alert("No se puede pagar esta cuota");
    </script>

    <%
            }
        }

        if (request.getParameter("vercuotas") != null) {
            id = request.getParameter("vercuotas");
        } else if (request.getParameter("iddetalleservicio") != null) {
            id = request.getParameter("iddetalleservicio");
        }

        int cantidad = cuotas.cantidadcuota(Integer.parseInt(id));
        int idDetalleventa = 0;
        int contador = 0;
        double monto = (ventas.costo(cuotas.idservicio(Integer.parseInt(id))) / cantidad);
        idDetalleventa = Integer.parseInt(id);
        ArrayList<PagoCuotas> aux = cuotas.MostrarCuotas(idDetalleventa);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagos</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>

            .table-wrapper-scroll-y {
                margin: 0 auto;
                display: block;
                max-height: 410px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
            }

        </style>
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

        <h1 class="text-center">Pagos</h1>
        <div class="container" style="border: 1px solid black; padding: 20px; background-color: white">
            <form name="registro" action="cuotas.jsp" method="post">
                <input type="hidden" id="cantidad" value="<%=cantidad - aux.size()%>">
                <input type="hidden" name="iddetalleservicio" value="<%=id%>">

                <div class="row">
                    <div class="col">
                        <h5 class="text-center">Pagos restantes: <%=((cantidad - aux.size()) > 0) ? cantidad - aux.size() : "No hay pagos"%></h5>
                    </div>
                </div>
                <br>

                <div class="row">
                    <div class="col">
                        <div class="table-wrapper-scroll-y ">
                            <table class="table table-hover">
                                <thead class="thead-dark text-center">
                                    <tr>
                                        <th scope="col">Numero de pago</th>
                                        <th scope="col">Fecha de pago</th>
                                        <th scope="col">Monto</th>
                                        <th scope="col">Estado</th>
                                    </tr>
                                <tbody class="text-center">
                                    <%
                                        Date fecha;
                                        fecha = new Date();

                                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                        String fechaPago = formato.format(fecha);

                                        for (PagoCuotas registro : aux) {%>
                                    <tr>
                                        <td><%=registro.getNumeroCuota()%></td>
                                        <td><%=registro.getFechacuota()%></td>
                                        <td>$<%=String.format("%.2f", registro.getMonto())%></td>
                                        <td>Pagado</td>
                                    </tr>
                                    <%contador++;
                                            monto = registro.getMonto();
                                        }%>
                                    <%if ((cantidad - aux.size()) != 0) {%>
                                    <tr>
                                        <td><%=contador + 1%></td>
                                        <td><%=fechaPago%></td>
                                        <td><%=String.format("%.2f", monto)%></td>
                                <input type="hidden" id="contador" value="<%=contador + 1%>">
                                <input type="hidden" name="sql" value="INSERT INTO pago_cuotas(fecha_pago, cuota, id_detalleventaservocio, numero_cuotas) VALUES ( '<%=fechaPago%>', <%=monto%>, <%=idDetalleventa%>, <%=contador + 1%>)">
                                <td><button type="submit" class="btn btn-primary" name="pagar"> Pagar</button></td>
                                </tr>
                                <%}%>
                            </table>
                        </div>
                    </div>
                </div>

                                <br>
                <button type="button" onclick="window.location.href = 'listaVentas.jsp'" class="btn btn-outline-secondary" >volver</button>
            </form>
        </div>
    </body>
</html>
