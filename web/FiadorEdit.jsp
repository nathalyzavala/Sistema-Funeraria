<%@page import="modelo.entidades.Cliente"%>
<%@page import="modelo.entidades.Fiador"%>
<%@page import="modelo.dao.dao_fiador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        modelo.dao.dao_fiador fiador = new dao_fiador();
        if (request.getParameter("btneditar") != null) {
            Fiador fiadormostrar = fiador.MostrarUnFiador(Integer.parseInt(request.getParameter("btneditar")));

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar fiador</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
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
        <h1 class="text-center">
            Modificar Fiador
        </h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <form action="ServletFiador" id="form" method="post">
                <input type="hidden" value="<%=request.getParameter("btneditar")%>" name="editarh">
            <div class="form-row">
                    <div class="col">
                        <label>DUI:</label>
                        <input type="text" maxlength="10" pattern="[0-9]{8}-[0-9]{1}" name="dui" id="dui" value="<%=(fiadormostrar.getDui()==null)? "":fiadormostrar.getDui()%>" class="form-control" required>
                    </div>
                </div>
            <div class="form-row">
                    <div class="col">
                        <label>Nombre:</label>
                       <input type="text" maxlength="100" name="nombre" value="<%=fiadormostrar.getNombre()%>" class="form-control" required=>
                    </div>
                    <div class="col">
                        <label>Telefono:</label>
                        <input type="text" maxlength="9" name="telefono" id="telefono" pattern="[0-9]{4}-[0-9]{4}" value="<%=fiadormostrar.getTelefono()%>" class="form-control" required=>
                    </div>
                </div>
                    <div class="form-row">
                    <div class="col">
                        <label>Direccion:</label>
                        <textarea name="direccion" maxlength="100" class="form-control" required><%=fiadormostrar.getDireccion()%></textarea>
                    </div>
                    <div class="col">
                        <label>Cliente:</label>
                        <select name="cliente" class="form-control">
                            <% for (Cliente registro : fiador.MostrarCliente()) {%>
                            <option value="<%= registro.getIdcliente()%>" <%=(registro.getIdcliente() == fiadormostrar.getIdcliente()) ? "selected" : ""%>><%= registro.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div> 
            <br>
            <div class="form-row">
                    <div class="col text-right">
                        <button type="submit" value="<%=fiadormostrar.getIdfiador()%>" onclick="validateDui()" id="btnmod"  name="editar" class="btn btn-secondary">Editar</button>
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-secondary" onclick="location.href='Fiadormuestra.jsp'">Cancelar</button>
                    </div>
                </div>
        </form>
        </div>
        <%} else 
                out.print("<h3> No hay datos </h3>");%>
                
    </body>
</html>
