

<%@page import="modelodao.DaoProducto"%>
<%@page import="modeloentidad.producto"%>
<%@page import="modeloentidad.DetalleServ"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% modelodao.DaoProducto productoo = new DaoProducto();
        producto modificar = (producto) request.getAttribute("modificar");
    %>
    <head>
        <title>Productos</title>
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
                max-height: 170px;
                overflow-y: auto;
                -ms-overflow-style: -ms-autohiding-scrollbar;
                width: 60%;
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

        <h1 class="text-center">Registro de Productos</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <form action="ProductoServlet" method="post" name="pro1">
                <div class="form-row">

                    <div class="col">
                        <label>Tipo Producto :</label>
                        <select name="tipo" required class="form-control">
                            <option value="1" <%=(modificar == null) ? "" : (modificar.getNombrproducto().toLowerCase().contains("caja funebre")) ? "selected" : ""%>>Caja Funebre</option>
                            <option value="2" <%=(modificar == null) ? "" : (!modificar.getNombrproducto().toLowerCase().contains("caja funebre")) ? "selected" : ""%>>Otro</option>
                        </select>
                    </div>

                    <div class="col">
                        <label for="nombre">Nombre Producto:</label>
                        <input type="text"  class="form-control" name="nombrep" maxlength="50" value="<%=(modificar == null) ? "" : (modificar.getNombrproducto().toLowerCase().contains("caja funebre"))?modificar.getNombrproducto().replaceAll("Caja Funebre  ", ""):modificar.getNombrproducto()%>"  <%=(modificar == null) ? "" : "readonly"%> required>
                    </div>
                </div>
                <br>
                <div class="form-row">
                    <div class="col">
                        <label for="precio">Precio Producto: $</label>
                        <input type="text" class="form-control" onKeypress="if (event.keyCode < 45 || event.keyCode > 57)
                                    event.returnValue = false;" name="precio" value="<%=(modificar == null) ? "" : modificar.getPrecioproducto()%>" required >

                    </div>
                    <div class="col">
                        <label for="canti">Cantidad Producto:</label>
                        <input type="number" class="form-control" min="1" max="10000" id="apellido"  name="cantidad" value="<%=(modificar == null) ? "" : modificar.getCantidadproducto()%>" required >

                    </div>
                    <div>
                        <input type="hidden"   name="id" value="<%=(modificar == null) ? "" : modificar.getIdproducto()%>" >
                    </div>

                </div>
                <div class="form-row">
                    <div class="col">
                        <label>&nbsp;</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col text-right">
                        <input type="submit" class="btn btn-secondary" onclick="validarenvio()"value="<%=(modificar == null) ? "Registrar" : "Modificar"%>" name="<%=(modificar == null) ? "registrar" : "modificar"%>" >

                    </div>
                    <div class="col">
                        <input type="submit" class="btn btn-secondary" name="cancelar" value="Cancelar">  

                    </div>

                </div>
            </form>
            <div class="row">
                <div class="col">
                    <label>&nbsp;</label>
                </div>
            </div>
            <div class="form-row">
                <div class="col">
                    <form action="ProductoServlet" method="post">
                        <table  class="table table-hover">
                            <thead class="thead-dark text-center" >
                                <tr>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col" colspan="2">Acción</th>

                                </tr>
                            </thead>

                            <tbody class="text-center">
                                <%for (producto cl : productoo.getProductoP()) {%>
                                <tr>
                                    <td><%=cl.getNombrproducto()%></td>
                                    <td><%=cl.getPrecioproducto()%></td>
                                    <td><%=cl.getCantidadproducto()%></td>
                                    <td><button name="btneditar" class="btn btn-primary" value="<%=cl.getIdproducto()%>" >Editar</button>&nbsp;&nbsp;&nbsp;<button name="borrar" class="btn btn-primary" value="<%=cl.getIdproducto()%>" >Eliminar</button></td>
                                </tr>
                                <%}%>
                            </tbody>

                        </table>
                    </form>

                </div>
            </div>

        </div>




        <script>

        </script>

    </body>
</html>