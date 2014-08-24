<%-- 
    Document   : RegistrarDonante
    Created on : 28-mar-2014, 9:17:02
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String tipo_doc = request.getAttribute("tipo_doc") != null ? (String) request.getAttribute("tipo_doc") : "";
    String nro_doc = request.getAttribute("nro_doc") != null ? (String) request.getAttribute("nro_doc") : "";
    String nombres = request.getAttribute("nombres") != null ? (String) request.getAttribute("nombres") : "";
    String primer_apellido = request.getAttribute("primer_apellido") != null ? (String) request.getAttribute("primer_apellido") : "";
    String segundo_apellido = request.getAttribute("segundo_apellido") !=null ? (String) request.getAttribute("segundo_apellido") : "";
    String telefono = request.getAttribute("telefono") != null ? (String) request.getAttribute("telefono") : "";
    String direccion = request.getAttribute("direccion") !=null ? (String) request.getAttribute("direccion") : "";
    String departamento = request.getAttribute("departamento") != null ? (String) request.getAttribute("departamento") : "";
    String municipio = request.getAttribute("municipio") != null ? (String) request.getAttribute("municipio") : "";
    String genero = request.getAttribute("genero") != null ? (String) request.getAttribute("genero") : "";
    String correo = request.getAttribute("correo") != null ? (String) request.getAttribute("correo") : "";
    String fecha_nacimiento = request.getAttribute("fecha_nacimiento") != null ? (String) request.getAttribute("fecha_nacimiento") : "";
    String fec_ultdonacion = request.getAttribute("fec_ultdonacion") != null ? (String) request.getAttribute("fec_ultdonacion") : "";
    String enfermedades = request.getAttribute("enfermedades") != null ? (String) request.getAttribute("enfermedades") : "";
    String habitos = request.getAttribute("habitos") != null ? (String) request.getAttribute("habitos") : "";
    String nom_responsable = request.getAttribute("nom_responsable") != null ? (String) request.getAttribute("nom_responsable") : "";
    String tel_responsable = request.getAttribute("tel_responsable") != null ? (String) request.getAttribute("tel_responsable") : "";
    String estado = request.getAttribute("estado") != null ? (String) request.getAttribute("estado") : "";
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Donante</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
        <div id="wrapper">

            <!-- Menu Horizontal -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Agrupación de Elementos en navbar para dispositivos mobiles-->
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
                            <ul class="dropdown-menu">
                                <li><a href="UsuarioServlet">Gestionar Usuario</a></li>
                                <li><a href="DonanteServlet">Gestionar Donante</a></li>
                                <li><a href="BolsaServlet">Gestionar Bolsa de Sangre</a></li>
                                <li><a href="HospitalServlet">Gestionar Hospital</a></li>
                                <li><a href="JornadaServlet">Gestionar Jornada de Donación</a></li>
                            </ul>                      
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-clipboard"></i> Reportes<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="ReporteUsuario.jsp">Reporte Usuarios</a></li>
                                <li><a href="ReporteJornada.jsp">Reporte Jornadas de Donación</a></li> 
                            </ul>
                        </li> 
                    </ul>


                    <!-- Coleccion de links del nav parte superior derecha -->
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li><a>Ayuda</a></li>
                        <li><a href="index.html">Salir</a></li>
                    </ul>

                </div> <!-- Fin Barra Colapsada -->
            </nav>



            <div class="container">
                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Gestionar Donantes</legend>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tipo_doc">Tipo de Documento</label>
                            <div class="col-md-4 input-group">
                                <select id="tipo_doc" name="tipo_doc" class="form-control">
                                    <option value="1">Tarjeta de Identidad</option>
                                    <option value="2">Cédula de Ciudadanía</option>
                                    <option value="3">Cédula de Extranjería</option>
                                    <option value="4">Pasaporte</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_doc">Número de Documento</label>  
                            <div class="col-md-4 input-group">
                                <input id="nro_doc" name="nro_doc" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombres">Nombres</label>  
                            <div class="col-md-4 input-group">
                                <input id="nombres" name="nombres" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="primer_apellido">Primer Apellido</label>  
                            <div class="col-md-4 input-group">
                                <input id="primer_apellido" name="primer_apellido" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="segundo_apellido">Segundo Apellido</label>  
                            <div class="col-md-4 input-group">
                                <input id="segundo_apellido" name="segundo_apellido" type="text" placeholder="" class="form-control input-md" required="">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono </label>  
                            <div class="col-md-4">
                                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                            <div class="col-md-4">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control input-md">
                                    <option value="1">Amazonas</option>
                                    <option value="2">Antioquia</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="municipio">Ciudad</label>
                            <div class="col-md-4 input-group">
                                <select id="municipio" name="municipio" class="form-control input-md">
                                    <option value="1">Medellín</option>
                                    <option value="2">Itaguí</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="genero">Género</label>
                            <div class="col-md-4 input-group">
                                <select id="genero" name="genero" class="form-control input-md">
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo Electrónico</label>  
                            <div class="col-md-4">
                                <input id="correo" name="correo" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fecha_nacimiento">Fecha de Nacimiento</label>  
                            <div class="col-md-4 input-group">
                                <input id="fecha_nacimiento" name="fecha_nacimiento" type="date" class="form-control input-md">
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fec_ultdonacion">Fecha Última Donación</label>  
                            <div class="col-md-4">
                                <input id="fec_ultdonacion" name="fec_ultdonacion" type="date"  class="form-control input-md">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="enfermedades">Enfermedades</label>
                            <div class="col-md-4 input-group">
                                <select id="enfermedades" name="enfermedades" class="form-control input-md">
                                    <option>Ninguna</option>
                                    <option value="1">Hepatitis A</option>
                                    <option value="2">Hepatitis B</option>
                                    <option value="">Cáncer</option>
                                    <option value="">Sida</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="habitos">Hábitos</label>
                            <div class="col-md-4 input-group">
                                <select id="habitos" name="habitos" class="form-control input-md">
                                    <option value="1">Ninguno</option>
                                    <option value="2">Fumar</option>
                                    <option value="3">Drogas</option>
                                    <option value="4">Alcohol</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nom_responsable">Nombre Responsable</label>  
                            <div class="col-md-4">
                                <input id="nom_responsable" name="nom_responsable" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tel_responsable">Teléfono Responsable</label>  
                            <div class="col-md-4">
                                <input id="tel_responsable" name="tel_responsable" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control input-md">
                                    <option value="1">Activo</option>
                                    <option value="2">Inactivo</option>
                                </select>
                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                            </div>
                        </div>


                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-4">
                            <!--<button type="button" class="btn btn-default" name="btnnuevo" id="btnnuevo">Nuevo</button>-->
                            <input type="submit" class="btn btn-default" name="accion" value="Guardar" id="btnguardar" />
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar">Consultar</button>
                            <input type="submit" class="btn btn-default" name="accion" value="Modificar" id="btnmodificar" /> 
                            <button type="button" class="btn btn-default" name="btneliminar" id="btneliminar">Eliminar</button> 
                        </div>

                    </fieldset>
                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="UsuarioServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Donante</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Número de Identificación</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_don" name="buscar_don" placeholder="" class="form-control input-md"  type="text">
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
