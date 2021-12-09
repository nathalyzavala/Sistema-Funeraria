

<%@page import="modelo.entidades.Cargo"%>
<%@page import="modelo.dao.Dao_cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% modelo.dao.Dao_cargo cargo = new Dao_cargo();%>
    <% Cargo modificar = (Cargo) request.getAttribute("modificar");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo</title>
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
                if (confirm('¿Desea eliminar cargo?')) {
                    document.tuformulario.submit();
                }
            }
            ;

            function validarNombre() {
                if (!$('input').is('[readonly]')) {
                    if (document.getElementById("nombre").value != "") {
                        document.getElementById('form').action = 'cargo.jsp';
                        document.getElementById('form').submit();
                    }
                }
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
            Cargo validacion = null;
            System.out.println("" + request.getParameter("nombre"));
            if (request.getParameter("nombre") != null) {
                validacion = new Cargo();
                if (Dao_cargo.validarNombre(request.getParameter("nombre"))) {
                    validacion.setNombre("");

                } else {
                    validacion.setNombre(request.getParameter("nombre"));
                }
                if (request.getParameter("salario").isEmpty()) {
                    validacion.setSalario(0);
                } else {
                    validacion.setSalario(Double.parseDouble(request.getParameter("salario")));
                }
            }

            if (request.getParameter("registrar") != null || request.getParameter("modificarc") != null) {
                validacion = null;
            }

        %>

        <h1 class="text-center"><%=(modificar == null) ? "Nuevo" : "Editar"%> Cargo</h1>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white;">

            <form action="ServletCargo" method="post" id="form">

                <input type="hidden" name="idcargo" value="<%=(modificar == null) ? "" : modificar.getId_cargo()%>"/>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="">Nombre del cargo: </label>
                            <input type="text" class="form-control" onblur="validarNombre()" id="nombre" name="nombre" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getNombre()) : modificar.getNombre()%>"placeholder="Ej: Motorista" required <%=(modificar == null) ? "" : "readonly"%>/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="">Salario </label>
                            <input type="number" class="form-control" name="salario"  min=”0″ max=”20000″ step="0.01" value="<%=(modificar == null) ? ((validacion == null) ? "" : validacion.getSalario()) : modificar.getSalario()%>" placeholder="Ej: $ 100.00" required/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col text-center">  
                        <input type="submit"   class="btn btn-secondary"
                               value="<%=(modificar == null) ? "Guardar" : "Modificar"%>"
                               name="<%=(modificar == null) ? "registrar" : "modificarc"%>" />
                        <input type="button" onclick="location.href = 'cargo.jsp'" value="Cancelar" class="btn btn-secondary">
                    </div>
                </div>





            </form>

            <form action="ServletCargo" method="post">
                <div class="table-wrapper-scroll-y" style="width: 60%;">
                    <table class="table table-hover">
                        <thead class="thead-dark text-center">
                            <tr>

                                <th scope="col">Nombre</th>
                                <th scope="col">Salario</th>
                                <th scope="col">Acción</th>

                            </tr>
                        </thead>
                        <br></br>
                        <tbody class="text-center">
                            <%
                                for (Cargo cli : cargo.getCargo()) {%>
                            <tr>
                                <td><%=cli.getNombre()%></td>
                                <td>$<%=String.format("%.2f", cli.getSalario())%></td>

                                <td>
                                    <button class="btn btn-primary readMore roundBtn" name="btneditarc" value="<%=cli.getId_cargo()%>">Editar</button>
                                    &nbsp;&nbsp;&nbsp;
                                    <button class="btn btn-primary readMore roundBtn" name="borrarc"  onclick="pregunta()" value="<%=cli.getId_cargo()%>">Borrar</button>

                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>
