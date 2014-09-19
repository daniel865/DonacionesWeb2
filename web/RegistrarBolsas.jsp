<%-- 
    Document   : RegistrarBolsas
    Created on : 19-mar-2014, 10:41:49
    Author     : daniel
--%>

<%@page import="com.donaciones.entities.Jornada"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String codigo = request.getAttribute("codigo") != null ? (String) request.getAttribute("codigo") : "";
    String grupo_sanguineo = request.getAttribute("grupo_sanguineo") != null ? (String) request.getAttribute("grupo_sanguineo") : "";
    String rh = request.getAttribute("rh") != null ? (String) request.getAttribute("rh") : "";
    String recoleccion = request.getAttribute("recoleccion") != null ? (String) request.getAttribute("recoleccion") : "";
    String vencimiento = request.getAttribute("vencimiento") != null ? (String) request.getAttribute("vencimiento") : "";
    String cantidad = request.getAttribute("cantidad") != null ? (String) request.getAttribute("cantidad") : "";
    String observaciones = request.getAttribute("observaciones") != null ? (String) request.getAttribute("observaciones") : "";
    String cod_jornada = request.getAttribute("cod_jornada") != null ? (String) request.getAttribute("cod_jornada") : "";
    String buscar_cod = request.getAttribute("buscar_cod") != null ? (String) request.getAttribute("buscar_cod") : "";
    String estado = request.getAttribute("estado") != null ? (String) request.getAttribute("estado") : "";
    boolean load = (Boolean) request.getAttribute("load") != null ? (Boolean) request.getAttribute("load") : false;
    List<Jornada> listJornada = (List<Jornada>) request.getAttribute("listJornada") != null ? (List<Jornada>) request.getAttribute("listJornada") : null;

    String user = request.getAttribute("user") != null ? (String) request.getAttribute("user") : "";
    String pass = request.getAttribute("pass") != null ? (String) request.getAttribute("pass") : "";
    String perfil = request.getAttribute("perfil") != null ? (String) request.getAttribute("perfil") : "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                user = cookie.getValue();
            }
            if (cookie.getName().equals("perfil")) {
                perfil = cookie.getValue();
            }
        }
    }
%>

<%if (mensaje != null) {%>
<script>
    alert('<%=mensaje%>');
</script>
<%}%>

<script>
    function recargarDatos() {
        $(function () {
            var jornada = <%=cod_jornada%>;
            $("#cod_jornada").val(jornada);
        });
        var estado = '<%=estado%>';
        var rh = '<%=rh%>';
        var grupo_sanguineo = '<%=grupo_sanguineo%>';
        var cod_jornada = '<%=cod_jornada%>';

        if (estado === "Activo") {
            $("#estado option[value=Activo]").attr("selected", true);
        }
        if (estado === "Inactivo") {
            $("#estado option[value=Inactivo]").attr("selected", true);
        }

        if (grupo_sanguineo === "A") {
            $("#grupo_sanguineo option[value=A]").attr("selected", true);
        }
        if (grupo_sanguineo === "B") {
            $("#grupo_sanguineo option[value=B]").attr("selected", true);
        }
        if (grupo_sanguineo === "AB") {
            $("#grupo_sanguineo option[value=AB]").attr("selected", true);
        }
        if (grupo_sanguineo === "O") {
            $("#grupo_sanguineo option[value=O]").attr("Selected", true);
        }

        if (rh === "Positivo") {
            $("#rh option[value=Positivo]").attr("selected", true);
        }
        if (rh === "Negativo") {
            $("#rh option[value=Negativo]").attr("selected", true);
        }
    }
</script>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Bolsas de Sangre</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/additional-methods.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.bootstrap.popover.min.js"></script>
        <script type="text/javascript" src="js/ValidacionesBolsas.js"></script>
    </head>
    <body onload="JavaScript: recargarDatos();">

        <script type="text/javascript">

                var perfil = '<%=perfil%>';
                alert("perfil bolsa: " + perfil);
                switch (perfil) {
                    case "Administrador":
                        $("#Ges_donante").hide();
                        $("#Ges_bolsa").hide();
                        $("#Ges_hospital").hide();
                        $("#Ges_jornada").hide();
                        break;
                    case "Auxiliar":
                        $("#Ges_bolsa").hide();
                        $("#Ges_hospital").hide();
                        $("#Ges_jornada").hide();
                        $("#Ges_usuario").hide();
                        break;
                    case "Bacteriologo":
                        $("#Ges_hospital").hide();
                        $("#Ges_jornada").hide();
                        $("#Ges_usuario").hide();
                        $("#Ges_donante").hide();
                        break;
                    case "Enfermera":
                        $("#Ges_hospital").hide();
                        $("#Ges_jornada").hide();
                        break;
                    case "Medico":
                        $("#Ges_usuario").hide();
                        $("#Ges_usuario").addClass(hide);
                        break;
                    default:
                        break;
                }

        </script>

        <div id="wrapper">

            <!-- Menu Horizontal -->
            <nav class="navbar navbar-fixed-top navbar-default" role="navigation">
                <!-- Agrupación de Elementos en navbar para dispositivos mobiles-->
                <div class="container">
                    <div class="navbar-header"> 
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <!-- Organizar data-target -->
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="Inicio.jsp">Donaciones Web</a>
                    </div>

                    <!-- Colección de Link del Nav para el dashboard  parte izquierda-->
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav side-nav">
                            <li><a href="Inicio.jsp"><i class="fa fa-dashboard"></i> Inicio</a></li>
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-save"></i> Gestionar <b class="caret"></b></a>
                                <ul id="Gestiones" class="dropdown-menu">
                                    <li id="Ges_usuario"><a href="UsuarioServlet">Usuario</a></li>
                                    <li id="Ges_donante"><a href="DonanteServlet">Donante</a></li>
                                    <li id="Ges_bolsa"><a href="BolsaServlet">Bolsa de Sangre</a></li>
                                    <li id="Ges_hospital"><a href="HospitalServlet">Hospital</a></li>
                                    <li id="Ges_jornada"><a href="JornadaServlet">Jornada de Donación</a></li>
                                </ul>                      
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-clipboard"></i> Reportes<b class="caret"></b></a>
                                <ul id="Reportes" class="dropdown-menu">
                                    <li id="Rep_usuario"><a href="ReporteUsuario.jsp">Usuarios</a></li>
                                    <li id="Rep_jornada"><a href="ReporteJornada.jsp">Jornadas de Donación</a></li> 
                                </ul>
                            </li> 
                        </ul>


                        <!-- Coleccion de links del nav parte superior derecha -->
                        <ul class="nav navbar-nav navbar-right navbar-user">
                            <li><a>Ayuda</a></li>
                            <li><a href="index.html">Salir</a></li>
                        </ul>

                    </div> <!-- Fin Barra Colapsada -->

                </div>
            </nav>

            <!--Inicio del Formulario -->
            <div class="container">
                <form id="FormBolsas" class="form-horizontal"  action="BolsaServlet" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Registrar Bolsas de Sangre</legend>

                        <br>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="codigo">Código Bolsa de Sangre*</label>  
                            <div class="col-md-4 input-group">
                                <input id="codigo" name="codigo" type="text" placeholder="" class="form-control input-md" required="" value="<%=codigo%>">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cod_jornada">Jornada de Donación*</label>
                            <div class="col-md-4 input-group">
                                <select id="cod_jornada" name="cod_jornada" class="form-control">
                                    <option value="">Selecione una Jornada</option>
                                    <%
                                        for (int index = 0; listJornada != null && index < listJornada.size(); index++) {
                                            Jornada jornada = listJornada.get(index);
                                    %>
                                    <option value="<%=jornada.getCodigo()%>"> <%= jornada.getDescripcion()%> </option>
                                    <%}%>
                                </select>

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="grupo_sanguineo">Grupo Sanguíneo*</label>
                            <div class="col-md-4 input-group">
                                <select id="grupo_sanguineo" name="grupo_sanguineo" class="form-control">
                                    <option value=""></option>
                                    <option value="A">A</option>
                                    <option value="AB">AB</option>
                                    <option value="B">B</option>
                                    <option value="O">O</option>
                                </select>

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="rh">Factor RH*</label>
                            <div class="col-md-4 input-group">
                                <select id="rh" name="rh" class="form-control">
                                    <option value=""></option>
                                    <option value="Positivo">+</option>
                                    <option value="Negativo">-</option>
                                </select>

                            </div>
                        </div>

                        <!-- Date Fecha de Recoleccion -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="recoleccion">Fecha de Recolección*</label>
                            <div class="col-md-4 input-group">
                                <input id="recoleccion" name="recoleccion" type="date" placeholder="" class="form-control input-md" required="" value="<%=recoleccion%>">

                            </div>
                        </div>

                        <!-- Date Fecha de Vencimiento -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="vencimiento">Fecha de Vencimiento*</label>
                            <div class="col-md-4 input-group">
                                <input id="vencimiento" name="vencimiento" type="date" placeholder="" class="form-control input-md" required="" value="<%=vencimiento%>">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cantidad">Cantidad de Sangre*</label>  
                            <div class="col-md-4 input-group">
                                <input id="cantidad" name="cantidad" type="text" placeholder="Cm3" class="form-control input-md" required="" value="<%=cantidad%>">

                            </div>
                        </div>                 

                        <!-- Textarea -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="observaciones">Observaciones</label>
                            <div class="col-md-4">                     
                                <textarea class="form-control" id="observaciones" name="observaciones"><%=observaciones%></textarea>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado*</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control">
                                    <option value=""></option>
                                    <option value="Activo">Activo</option>
                                    <option value="Inactivo">Inactivo</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group container" style="margin-left: 290px;">
                            <label class="col-md-4 control-label">Los campos con * son obligatorios</label>
                        </div>

                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-5">
                            <input type="submit" class="btn btn-default " name="accion" value="Guardar" id="btnguardar" style="margin-left: 10px;" />
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar" style="margin-left: 10px;">Consultar</button>
                            <input type="submit" class="btn btn-default" name="accion" value="Modificar" id="btnmodificar" style="margin-left: 10px;"/> 
                            <button type="button" class="btn btn-default" name="btneliminar" id="btneliminar" style="margin-left: 10px;">Eliminar</button> 
                        </div>

                        <br/>
                        <br/>

                    </fieldset>
                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="BolsaServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Bolsa de Sangre</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Código de Bolsa</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_bol" name="buscar_bol" placeholder="" class="form-control input-md"  type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <input type="submit" value="Consultar" class="btn btn-primary" name="accion" id="btnbuscarb">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


            </div>

        </div>    


    </body>
</html>
