
<%@page import="dao.Dao_Cargos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Dao_Venta"%>
<%@page import="dao.Dao_Clientes"%>
<%@page import="entidades.Empleado"%>
<%@page import="dao.Dao_Empleados"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.*"%>
<%@page import="entidades.DetalleServicio"%>
<%@page import="dao.Dao_Servicios"%>
<%@page import="entidades.Producto"%>
<%@page import="dao.Dao_Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="icon" href="imagenes/icon.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <title>Realizar Venta</title>
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
    <script>
        function escogerServicio() {
            document.getElementById("servicios").submit();
        }
        ;


        function agregarVenta() {
            var form = document.getElementById("agregarForm");
            form.action = "detalleVenta.jsp";
            form.submit();
        }
        ;

        function limpiar() {
            location.reload();
        }
        ;

        function seleccion() {
            document.getElementById("serv").options.item(0).selected = 'selected';
            escogerServicio();
        }
        ;
        
        function agregarEmpleado(){
            if(document.getElementById("agregarEmpleadoSelect").value == "agregar"){
                escogerServicio();
            }
            
        }
        
        function agregarCliente(){
            if(document.getElementById("agregarClienteSelect").value == "agregar"){
                escogerServicio();
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


        <h1 class="text-center">Venta</h1>



        <%
            if (request.getParameter("limpiar") != null) {
                if (request.getParameterValues("agregado") != null) {
                    String[] eliminar = request.getParameterValues("agregado");
                    if (eliminar != null) {
                        for (String elem : eliminar) {
                            Dao_Venta.eliminarVenta(Integer.parseInt(elem));
                        }
                    }
                }
            }

            if (request.getParameter("add") != null) {
                entidades.EncabezadoVenta encabezado = new entidades.EncabezadoVenta(new entidades.Empleado(Integer.parseInt(request.getParameter("idEmpleado"))), request.getParameter("fechaV"), new entidades.Cliente(Integer.parseInt(request.getParameter("idCliente"))));
                entidades.Servicio servicio = new entidades.Servicio(Dao_Venta.costo(Integer.parseInt(request.getParameter("idServicio"))), Integer.parseInt(request.getParameter("idServicio")));
                int cuotas = Integer.parseInt(request.getParameter("cuota"));
                Dao_Venta.registrarVenta(new entidades.DetalleVenta(encabezado, servicio, cuotas));

            }

            if (request.getParameter("eliminarAgregado") != null) {
                Dao_Venta.eliminarVenta(Integer.parseInt(request.getParameter("eliminarAgregado")));
            }

            Servicio auxServicio = null;
            Empleado auxEmpleado = null;
            Cliente auxCliente = null;
            String fecha = "";
            String tipoVenta = "";
            //segundo form
            if ((request.getParameter("idServicio") != null)) {
                auxServicio = Dao_Servicios.getServicio(request.getParameter("idServicio"));
            }

            if (request.getParameter("idEmpleado") != null) {
                auxEmpleado = Dao_Empleados.getEmpleado(request.getParameter("idEmpleado"));
            }
            if (request.getParameter("idCliente") != null) {
                auxCliente = Dao_Clientes.getCliente(request.getParameter("idCliente"));
            }
            if (request.getParameter("fechaV") != null) {
                fecha = request.getParameter("fechaV");
            }

            //primer form
            if ((request.getParameter("tipoVenta") != null)) {
                tipoVenta = (request.getParameter("tipoVenta"));
            }

            if ((request.getParameter("servicio") != null)) {
                auxServicio = Dao_Servicios.getServicio(request.getParameter("servicio"));
            }

            if (request.getParameter("empleado") != null) {
                if (!request.getParameter("empleado").equals("agregar")) {
                    auxEmpleado = Dao_Empleados.getEmpleado(request.getParameter("empleado"));
                }
            }
            if (request.getParameter("cliente") != null) {
                if (!request.getParameter("cliente").equals("agregar")) {
                    auxCliente = Dao_Clientes.getCliente(request.getParameter("cliente"));
                }
                
            }
            if (request.getParameter("fecha") != null) {
                fecha = request.getParameter("fecha");
            }


        %>
        <div class="container rounded divScroll" style="border: 1px solid black; padding: 20px; background-color: white">
            <form action="detalleVenta.jsp" method="post" id="servicios">
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <label>Fecha</label>
                            <%  Date fechaA = new Date();
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String fechaVenta = formato.format(fechaA);
                            %>
                            <input type="date" class="form-control" name="fecha" value="<%=fechaVenta%>" readonly>
                        </div>
                    </div>
                    <div class="col">
                        <label>Empleado</label> 
                        <select name="empleado" id="agregarEmpleadoSelect" onchange="escogerServicio()" onclick="agregarEmpleado()" class="form-control" required>
                            <option value="-1" disabled>Seleccione</option>
                            <%for (Empleado empleado : Dao_Empleados.getEmpleados()) {
                                System.out.println(empleado.getCargo().getNombre());
                                if(empleado.getCargo().getNombre().equals("Vendedor")){
                            %>
                            <option value="<%=empleado.getId()%>" <%= (auxEmpleado != null) ? ((auxEmpleado.getId() == empleado.getId()) ? "selected" : "") : ""%>><%=empleado.getNombre()%> <%=empleado.getApellidos()%></option> 
                            <%
                                }}
                            %>
                            <option value="agregar" name="agregarEmpleado">Agregar...</option>
                        </select>
                    </div>
                    <div class="col">
                        <label>Tipo Venta:</label> 
                        <select name="tipoVenta" onchange="escogerServicio()" class="form-control" required>
                            <option value="cuotas" <%= (!tipoVenta.isEmpty()) ? ((tipoVenta.equals("cuotas")) ? "selected" : "") : ""%>>Cuotas</option>
                            <option value="contado"  <%= (!tipoVenta.isEmpty()) ? ((tipoVenta.equals("contado")) ? "selected" : "") : ""%>>Contado</option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <label>Cliente</label> 
                            <select name="cliente" id="agregarClienteSelect" onchange="escogerServicio()" onclick="agregarCliente()" class="form-control" required>
                                <option value="-1" disabled>Seleccione</option>
                                <%for (Cliente cliente : Dao_Clientes.getClientes()) {
                                %>
                                <option value="<%=cliente.getId()%>" <%= (auxCliente != null) ? ((auxCliente.getId() == cliente.getId()) ? "selected" : "") : ""%>><%=cliente.getNombre()%>  <%=cliente.getApellidos()%></option> 
                                <%
                                    }
                                %>
                                <option value="agregar" name="agregarCliente">Agregar...</option>
                            </select>
                        </div>
                    </div>
                        <div class="col">
                            <div class="form-group">
                                <label>Servicios</label> 
                                <select name="servicio" onchange="escogerServicio()" class="form-control" id="serv">
                                    <option value="-1">Seleccione</option>
                                    <%for (Servicio servicio : Dao_Servicios.getServicios()) {

                                       ArrayList<DetalleServicio> detalles = Dao_Servicios.getDetalles(servicio.getId());
                                       ArrayList<Producto> existencias = Dao_Servicios.getExistencias(servicio.getId());

                                       boolean mostrarServicio = true;

                                       if(detalles.isEmpty()){
                                           mostrarServicio = false;
                                       }

                                       if(existencias.isEmpty()){
                                           mostrarServicio = false;
                                       }

                                       for (DetalleServicio detalle : detalles) {
                                               for (Producto existencia : existencias) {
                                                       if(existencia.getExistencia()<detalle.getCantidad()){
                                                           mostrarServicio = false;
                                                       }
                                                   }
                                           }
                                       
                                       if(mostrarServicio){
                                    %>
                                    <option value="<%=servicio.getId()%>" onclick="escogerServicio()" <%= (auxServicio != null) ? ((auxServicio.getId() == servicio.getId()) ? "selected" : "") : ""%>><%=servicio.getNombre()%></option> 
                                    <%
                                        }}
                                    %>
                                </select>
                            </div>
                        </div>
                </div>
            </form>

            <form method="post" action="Comprobante.jsp" id="agregarForm">
                <%
                    if (auxEmpleado != null) {
                %>
                <input type="hidden" name="idEmpleado" value="<%=auxEmpleado.getId()%>">
                <%
                    }
                %>

                <%
                    if (auxCliente != null) {
                %>
                <input type="hidden" name="idCliente" value="<%=auxCliente.getId()%>">
                <%
                    }
                %>

                <%
                    if (fecha != null) {
                %>
                <input type="hidden" name="fechaV" value="<%=fecha%>">  
                <%
                    }
                %>


                <%if (auxServicio != null) {%>
                <input type="hidden" name="idServicio" value="<%=auxServicio.getId()%>">
                <%
                    if (Dao_Servicios.getDetalles(auxServicio.getId()).size() > 0) {%>
                <div class="table-wrapper-scroll-y">
                    <table class="table table-hover">
                        <thead class="thead-dark">
                        <th scope="col">Producto</th>
                        <th scope="col">Cantidad</th>
                        </thead>
                        <tbody>
                            <%
                                for (DetalleServicio detalle : Dao_Servicios.getDetalles(auxServicio.getId())) {
                            %>            
                            <tr>
                                <td>
                                    <%=detalle.getProducto().getNombre()%>
                                </td>
                                <td>
                                    <%=detalle.getCantidad()%>
                                </td>
                            </tr>  
                            <%}%>
                        </tbody>
                    </table>
                </div>

                <div class="row">
                    <div class="col">
                        <h5 class="text-right">Costo: $<%= String.format("%.2f", auxServicio.getCosto())%></h5>
                    </div>
                    <div class="col">
                        <button type="submit" name="add" class="btn btn-primary" value="<%=auxServicio.getId()%>" onclick="agregarVenta()">Agregar</button>
                    </div>
                </div>



                <%}
                    }
                %>
                <div class="form-row">
                    <div class="col">
                        <div class="form-group">
                            <label>Cuotas</label>
                            <input type="number" name="cuota"  min="2" max="48" step="1" value="<%= (!tipoVenta.isEmpty()) ? ((tipoVenta.equals("contado")) ? 1 : 2) : 2%>" class="form-control" <%=(!tipoVenta.isEmpty()) ? ((tipoVenta.equals("contado") ? "readonly" : "")) : ""%>>
                        </div>
                    </div>
                    <div class="col">
                    </div>
                    <div class="col">
                    </div>
                </div>
                <%
                    ArrayList<DetalleVenta> servicios = null;
                    double acumulador = 0;
                    if (auxCliente != null) {
                        servicios = Dao_Servicios.getServiciosAgregados(auxCliente.getId());

                        if (servicios != null) {
                            if (servicios.size() > 0 && auxCliente != null) {
                %>
                <div class="form-row">
                    <div class="col">

                        <div class="table-wrapper-scroll-y" style="width: 60%;">
                            <table class="table table-hover">
                                <thead class="thead-dark">
                                <th scope="col">Servicio</th>
                                <th scope="col">Costo</th>
                                <th scope="col">Acción</th>
                                </thead>
                                <tbody>
                                    <%
                                        for (DetalleVenta detalle : Dao_Servicios.getServiciosAgregados(auxCliente.getId())) {
                                    %>            
                                    <tr>
                                        <td>
                                            <input type="hidden" name="agregado" value="<%=detalle.getId()%>">
                                            <%=detalle.getServicio().getNombre()%>
                                        </td>
                                        <td>
                                            $<%=String.format("%.2f", detalle.getServicio().getCosto())%>
                                        </td>
                                        <td>
                                            <button type="submit" name = "eliminarAgregado" value="<%=detalle.getId()%>" onclick="agregarVenta()" class="btn btn-secondary">Eliminar</button>
                                        </td>
                                    </tr>  
                                    <%
                                            acumulador += detalle.getServicio().getCosto();
                                        }
                                    %>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col">
                        <h5 class="text-center">
                            Costo Total: $<%=String.format("%.2f", acumulador)%>
                        </h5>
                    </div>
                </div>
                <br>
                <%          }
                        }
                    }
                %>
                <% if (servicios != null && servicios.size() > 0) {
                %>
                <div class="form-row">
                    <div class="col text-right">

                        <button type="submit" onclick="window.open('detalleVenta.jsp', '_blank');" name = "registrarVenta" value="<%=auxCliente.getId()%>" class="btn btn-secondary">Realizar Venta</button>

                    </div>
                    <div class="col">
                        <input type="submit" name = "limpiar" value="Cancelar Venta" onclick="agregarVenta()" class="btn btn-secondary">
                    </div>

                </div>
                <%}%>
            </form>
        </div>

        <!--Modal cliente-->    

        <div class="modal fade" id="agregarCliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar un Cliente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                        <div class="tabla_modal">
                            <form action="ControladorVenta" method="post" class="needs-validation" novalidate>
                                <div class="registro" style="width: 95%; margin: 0 auto;">
                                    <div style="width: 85%; margin: 0 auto;">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*DUI </label>
                                                    <input type="text" maxlength="10" id="dui" class="form-control" name="duiCliente" pattern="^[0-9]{8}-[0-9]{1}$" placeholder="12345678-9" required>
                                                    <div class="invalid-tooltip">
                                                        Formato incorrecto de dui
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Nombres</label>
                                                    <input type="text" maxlength="50" class="form-control" name="nombreCliente" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Apellidos</label>
                                                    <input type="text" maxlength="50" class="form-control" name="apellidoCliente" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Telefono</label>
                                                    <input type="text" maxlength="9" id="telefono" class="form-control" name="telefonoCliente" pattern="^[0-9]{4}-[0-9]{4}$" placeholder="1234-5678" required>
                                                    <div class="invalid-tooltip">
                                                        Formato incorrecto de telefono
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Dirección</label>
                                                    <textarea name="direccionCliente" class="form-control" required></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col text-center">
                                                    <button type="submit" class="btn btn-secondary" value="registrar" name="registrarCliente">Registrar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Modal empleados-->    

        <div class="modal fade" id="agregarEmpleado" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar un Empleado</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="tabla_modal">
                            <form action="ControladorVenta" method="post" class="needs-validation" novalidate>
                                <div class="registro" style="width: 95%; margin: 0 auto;">
                                    <div style="width: 85%; margin: 0 auto;">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*DUI </label>
                                                    <input type="text" maxlength="10" id="dui" class="form-control" name="duiEmpleado" pattern="^[0-9]{8}-[0-9]{1}$" placeholder="12345678-9" required>
                                                    <div class="invalid-tooltip">
                                                        Formato incorrecto de dui
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Nombres</label>
                                                    <input type="text" maxlength="50" class="form-control" name="nombreEmpleado" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Apellidos</label>
                                                    <input type="text" maxlength="50" class="form-control" name="apellidoEmpleado" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Telefono</label>
                                                    <input type="text" maxlength="9" id="telefono" class="form-control" name="telefonoEmpleado" pattern="^[0-9]{4}-[0-9]{4}$" placeholder="1234-5678" required>
                                                    <div class="invalid-tooltip">
                                                        Formato incorrecto de telefono
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Dirección</label>
                                                    <textarea name="direccionEmpleado" class="form-control" required></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Fecha Nacimiento</label>
                                                    <input type="date" name="fechaNacimiento" class="form-control" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Fecha Contrato</label>
                                                    <input type="date" name="fechaContrato" class="form-control" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-control-label">*Correo electronico</label>
                                                    <input type="email" class="form-control" name="correoEmpleado" placeholder="correo@ejemplo.com" required>
                                                    <div class="invalid-tooltip">
                                                        Formato incorrecto de correo
                                                    </div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col">
                                                    <label>*Cargo</label>
                                                    <select name="cargo" class="form-control">
                                                        <%
                                                            if (Dao_Cargos.getCargos() != null) {
                                                                for (Cargo cargo : Dao_Cargos.getCargos()) {
                                                                    if (!cargo.getNombre().equals("Gerente")){
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

                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col text-center">
                                                    <button type="submit" class="btn btn-secondary" value="registrarEmpleado" name="registrarEmpleado">Registrar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>


        <%
            if (request.getParameter("empleado") != null) {
                if (request.getParameter("empleado").equals("agregar")) {
        %>   
        <script>
            $("#agregarEmpleado").modal();
        </script>
        <%}
            }%>

        <%

            if (request.getParameter ( 
                "cliente") != null) {
                if (request.getParameter("cliente").equals("agregar")) {
        %>   
        <script>
            $("#agregarCliente").modal();
        </script>
        <%}
            }%>

        <script>
            (function () {
                'use strict';
                window.addEventListener('load', function () {
                    var forms = document.getElementsByClassName('needs-validation');

                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();

        </script>

    </body>
</html>
