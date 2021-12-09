

<%@page import="modeloentidad.servicio"%>
<%@page import="modelodao.DaoServicio"%>
<%@page import="modeloentidad.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% modelodao.DaoServicio servicio = new DaoServicio();
        servicio modificar = (servicio) request.getAttribute("modificar");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                max-height: 200px;
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
    </head>

    <script>
        function validarenvio() {
            if (document.pro1.cantidad <= 0) {
                alert("Cantidad de Productos debe Ser mayor a Cero");
                document.pro1.cantidad.focus();
                return 0;
            }

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

        <h1 class="text-center">Registrar Servicios</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">

            <form action="ServicioServlet"  method="post">
                <div class="form-row">
                    <div class="col">
                        <label  id="nombre_servicio">Nombre</label>
                        <input class="form-control" type="text" name="nombres" maxlength="100"  value="<%=(modificar == null) ? "" : modificar.getNombreServicio()%>" required/>
                    </div>
                    <div class="col">
                        <label idcosto">Precio $</label>
                        <input readonly="readonly" type="text"  name="costos" onKeypress="if (event.keyCode < 45 || event.keyCode > 57)
                                    event.returnValue = false;" value="<%=(modificar == null) ? "0" : modificar.getCosto()%>" required class="form-control"/>
                    </div>
                </div>
                <div>
                    <input type="hidden"   name="id" value="<%=(modificar == null) ? "" : modificar.getId_servicio()%>" >
                </div>
                <div class="form-row">
                    <div class="col text-center">
                        <label>&nbsp;</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col text-center">
                        <input type="submit" class="btn btn-secondary" onclick="validarenvio()" value="<%=(modificar == null) ? "Registrar" : "Modificar"%>" name="<%=(modificar == null) ? "registrar" : "modificar"%>"/>
                        <input type="reset"  class="btn btn-secondary" name="cancelar" value="Cancelar"/>
                    </div>
                </div>

            </form>
                <div class="form-row">
                    <div class="col text-center">
                        <label>&nbsp;</label>
                    </div>
                </div>          
            <form action="ServicioServlet" method="post">
                <div  class="table-wrapper-scroll-y">
                    <table class="table table-hover">
                        <thead class="thead-dark text-center">
                            <tr>
                                <th scope="col" >Nombre Servicio</th>
                                <th scope="col" >Costo del servicio</th>
                                <th scope="col" colspan="2">Acción</th>
                            </tr>
                        </thead>

                        <tbody class="text-center">
                            <%for (servicio cl : servicio.getServicio()) {%>
                            <tr>
                                <td><%=cl.getNombreServicio()%></td>
                                <td><%=String.format("%.2f",cl.getCosto())%></td>
                                <td><button name="btneditar" value="<%=cl.getId_servicio()%>"  class="btn btn-primary">Editar</button>
                                    &nbsp;&nbsp;&nbsp;
                                <button name="borrar" value="<%=cl.getId_servicio()%>" class="btn btn-primary">Borrar</button></td>
                            </tr>
                            <%}%>
                        </tbody>

                    </table>
                </div>
            </form>   
        </div>
    </body>
</html>
