<%-- 
    Document   : Usuario
    Created on : 1/03/2014, 12:46:29 PM
    Author     : sala306
--%>

<%@page import="com.donaciones.entities.Usuario" %>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario datos = (Usuario) request.getSession().getAttribute("usuario") != null ? (Usuario) request.getSession().getAttribute("usuario") : null;
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String nro_identificacion = request.getAttribute("nro_identificacion") != null ? (String) request.getAttribute("nro_identificacion") : "";
    String nombres = request.getAttribute("nombres") != null ? (String) request.getAttribute("nombres") : "";
    String apellido1 = request.getAttribute("apellido1") != null ? (String) request.getAttribute("apellido1") : "";
    String apellido2 = request.getAttribute("apellido2") != null ? (String) request.getAttribute("apellido2") : "";
    String usuario = request.getAttribute("usuario") != null ? (String) request.getAttribute("usuario") : "";
    String correo = request.getAttribute("correo") != null ? (String) request.getAttribute("correo") : "";
    String pass = request.getAttribute("pass") != null ? (String) request.getAttribute("pass") : "";
    String user_perfil = request.getAttribute("user_perfil") != null ? (String) request.getAttribute("user_perfil") : "";
    String estado = request.getAttribute("estado") != null ? (String) request.getAttribute("estado") : "";
    String buscar_usu = request.getAttribute("buscar_usu") != null ? (String) request.getAttribute("buscar_usu") : "";

    String user = request.getAttribute("user") != null ? (String) request.getAttribute("user") : "";
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


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrapValidator.js"></script>
        <script type="text/javascript" src="js/validateUsuario.js"></script>

        <%if (mensaje != null) {%>
        <script>
    $(document).ready(function () {
        var estado = '<%=estado%>';
        if (estado === "Activo") {
            $("#estado option[value=Activo]").attr("selected", true);
        }
        if (estado === "Inactivo") {
            $("#estado option[value=Inactivo]").attr("selected", true);
        }
        var perfil = '<%=user_perfil%>';
        console.log(perfil);
        if (perfil === "Medico") {
            $("#user_perfil option[value=Medico]").attr("selected", true);
        }
        if (perfil === "Enfermera") {
            $("#user_perfil option[value=Enfermera]").attr("selected", true);
        }
        if (perfil === "Bacteriologo") {
            $("#user_perfil option[value=Bacteriologo]").attr("selected", true);
        }
        if (perfil === "Administrador"){
            $("#user_perfil option[value=Administrador]").attr("selected", true);
        }
        if (perfil === "Auxiliar"){
             $("#user_perfil option[value=Auxiliar]").attr("selected", true);
        }
        
    });

    //alert(estado);
        </script>
        <%}%>   


    </head>
    <body>

        <script type="text/javascript">
            $(document).ready(function () {
                var perfil = '<%=perfil%>';
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
                        break;
                    default:
                        break;
                }
            });
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
                            <li><a href="Logout">Salir</a></li>
                        </ul>

                    </div> <!-- Fin Barra Colapsada -->

                </div>
            </nav>




            <div class="container" >

                <form name="FormUsuario" id="FormUsuario" class="form-horizontal"  action="UsuarioServlet" method="POST">
                    <fieldset>


                        <!-- Form Name -->
                        <legend>Registrar Usuario</legend>

                        <br>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_identificacion">Número de Identificación*</label>  
                            <div class="col-md-4 input-group">
                                <input id="nro_identificacion" name="nro_identificacion" type="text" placeholder="" class="form-control input-md" value="<%=nro_identificacion%>" >

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombres">Nombres*</label>
                            <div class="col-md-4 input-group">
                                <input id="nombres" name="nombres" placeholder="" class="form-control input-md"  required="" type="text" value="<%=nombres%>" >
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="apellido1">Primer Apellido*</label>  
                            <div class="col-md-4 input-group">
                                <input id="apellidos" name="apellido1" placeholder="" class="form-control input-md" required="" type="text" value="<%=apellido1%>" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="apellido2">Segundo Apellido</label>  
                            <div class="col-md-4 input-group">
                                <input id="apellidos" name="apellido2" placeholder="" class="form-control input-md"  type="text" value="<%=apellido2%>" >
                            </div>
                        </div>        

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="usuario">Usuario*</label>  
                            <div class="col-md-4 input-group">
                                <input id="usuario" name="usuario" placeholder="" class="form-control input-md"  type="text" value="<%=usuario%>" >
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pass">Contraseña*</label>
                            <div class="col-md-4 input-group">
                                <input id="pass" name="pass" placeholder="" class="form-control input-md"  type="password" value="<%=pass%>" >
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pass2">Confirme Contraseña</label>
                            <div class="col-md-4 input-group">
                                <input id="pass2" name="pass2" placeholder="" class="form-control input-md"  type="password" value="<%=pass%>" >
                            </div>
                        </div>

                        <!-- Campo de Correo -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo electrónico*</label>
                            <div class="col-md-4 input-group">
                                <input id="correo" name="correo" placeholder="" class="form-control input-md"  type="text" value="<%=correo%>" >
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="perfil">Perfil*</label>
                            <div class="col-md-4 input-group">
                                <select id="user_perfil" name="user_perfil" class="form-control" >
                                    <option value=""></option> 
                                    <option value="Administrador">Administrador</option>
                                    <option value="Auxiliar">Auxiliar</option>
                                    <option value="Bacteriologo">Bacteriólogo(a)</option>
                                    <option value="Enfermera">Enfermera(o)</option>
                                    <option value="Medico">Médico</option>                  
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado*</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control"  >
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
                            <input type="submit" class="btn btn-primary" name="accion" value="Guardar" id="btnguardar" style="margin-left: 10px;" />

                            <!-- Split button -->
                            <div class="btn-group btn-primary" style="margin-left: 10px;">
                                <button type="button" class="btn btn-primary">Buscar</button>
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#" data-toggle="modal" data-target="#ModalBuscar">Número de Identifiación</a></li>
                                    <li><a href="#" data-toggle="modal" data-target="#ModalConsultar">Nombre de Usuario</a></li>
                                </ul>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Modificar" id="btnmodificar" style="margin-left: 10px;" /> 
                            <button type="reset" class="btn btn-primary" name="btnlimpiar" id="btnlimpiar" style="margin-left: 10px;">Limpiar</button>
                            
                        </div>

                    </fieldset>

                    <br/>
                    <br/>
                    <br/>
                    <br/>

                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="UsuarioServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Usuario</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Número de Identificación</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_usu" name="buscar_usu" placeholder="" class="form-control input-md"  type="text">
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

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="UsuarioServlet" method="POST" >
                    <div class="modal fade" id="ModalConsultar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Usuario</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Nombre de Usuario</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_usu" name="buscar_usu" placeholder="" class="form-control input-md"  type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <input type="submit" value="Buscar" class="btn btn-primary" name="accion" id="btnbuscarn">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


            </div>
        </div>




    </body>
</html>
