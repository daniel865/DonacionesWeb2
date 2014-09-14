<%-- 
    Document   : RegistrarHospital
    Created on : 19-mar-2014, 11:16:39
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Hospital</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="css/dashboard.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/additional-methods.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.bootstrap.popover.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#FormHospital').validate_popover({
                    rules: {
                        tipo: {
                            required: true
                        },
                        nit: {
                            digits: true,
                            required: true
                        },
                        razon: {
                            lettersonly: true,
                            required: true
                        },
                        direccion: {
                            required: true
                        },
                        departamento: {
                            required: true
                        },
                        municipio: {
                            required: true
                        },
                        telefono: {
                            required: true,
                            digits: true
                        },
                        representante: {
                            lettersonly: true,
                            required: true
                        },
                        tel_representante: {
                            digits: true,
                            required: true
                        },
                        correo_representante: {
                            email: true,
                            required: true
                        },
                        nivel: {
                            required: true
                        },
                        estado: {
                            required: true
                        }
                    },
                    messages: {
                        tipo: {
                            required: "Campo Obligatorio"
                        },
                        nit: {
                            required: "Campo Obligatorio",
                            digits: "Números únicamente"
                        },
                        razon: {
                            lettersonly: "Letras únicamente",
                            required: "Campo Obligatorio"
                        },
                        direccion: {
                            required: "Campo Obligatorio"
                        },
                        departamento: {
                            required: "Campo Obligatorio"
                        },
                        municipio: {
                            required: "Campo Obligatorio"
                        },
                        telefono: {
                            required: "Campo Obligatorio",
                            digits: "Por favor, Ingrese solamente números"
                        },
                        representante: {
                            lettersonly: "Letras únicamente",
                            required: "Campo Obligatorio"
                        },
                        tel_representante: {
                            required: "Campo Obligatorio",
                            digits: "Por favor, Ingrese solamente números"
                        },
                        correo_representante: {
                            required: "Campo Obligatorio",
                            email: "El correo no es válido"
                        },
                        nivel: {
                            required: "Campo Obligatorio"
                        },
                        estado: {
                            required: "Campo Obligatorio"
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                        //$(element).closest('.ocultar').removeClass('success').addClass('glyphicon glyphicon-ok form-control-feedback');
                    },
                    success: function(element) {
                        element
                                .text('OK!').addClass('valid')
                                .closest('.form-group').removeClass('has-error').addClass('has-success');
                        //.closest('.ocultar').removeClass('glyphicon glyphicon-ok form-control-feedback').addClass('has-success');
                    }
                });
            });
        </script>
    </head>
    <body>

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
                                <ul class="dropdown-menu">
                                    <li><a href="UsuarioServlet">Usuario</a></li>
                                    <li><a href="DonanteServlet">Donante</a></li>
                                    <li><a href="BolsaServlet">Bolsa de Sangre</a></li>
                                    <li><a href="HospitalServlet">Hospital</a></li>
                                    <li><a href="JornadaServlet">Jornada de Donación</a></li>
                                </ul>                      
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-clipboard"></i> Reportes<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ReporteUsuario.jsp">Usuarios</a></li>
                                    <li><a href="ReporteJornada.jsp">Jornadas de Donación</a></li> 
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


            <!-- Inicio del Formulario-->
            <div class="container">
                <form id="FormHospital" name="FormHospital" class="form-horizontal"  action="HospitalServlet" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Registrar Hospital</legend>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tipo">Tipo de Hospital*</label>
                            <div class="col-md-4 input-group">
                                <select id="tipo" name="tipo" class="form-control input-md">
                                    <option value=""></option>
                                    <option value="1">Privado</option>
                                    <option value="2">Público</option>
                                    <option value="3">Clínica</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nit">NIT Hospital*</label>  
                            <div class="col-md-4 input-group">
                                <input id="nit" name="nit" type="text" placeholder="" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="razon">Razón Social*</label>  
                            <div class="col-md-4 input-group">
                                <input id="razon" name="razon" type="text" placeholder="" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección*</label>  
                            <div class="col-md-4 input-group">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento*</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control input-md">
                                    <option value=""></option>
                                    <option value="1">Antioquia</option>
                                    <option value="2">Amazonas</option>
                                    <option value="">Arauca</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="municipio">Municipio* </label>
                            <div class="col-md-4 input-group">
                                <select id="municipio" name="municipio" class="form-control input-md">
                                    <option value=""></option>
                                    <option value="1">Abejorral</option>
                                    <option value="2">Andes</option>
                                    <option value="">Angostura</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono*</label>  
                            <div class="col-md-4 input-group">
                                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="representante">Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="representante" name="representante" type="text" placeholder="" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tel_representante">Teléfono Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="tel_representante" name="tel_representante" type="text" placeholder="" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo_representante">Correo Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="correo_representante" name="correo_representante" type="text" placeholder="" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nivel">Nivel Hospital*</label>
                            <div class="col-md-4 input-group">
                                <select id="nivel" name="nivel" class="form-control input-md">
                                    <option value=""></option>
                                    <option value="1">Primer Nivel</option>
                                    <option value="2">Segundo Nivel</option>
                                    <option value="3">Tercer Nivel</option>
                                </select>

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado*</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control input-md">
                                    <option value=""></option>
                                    <option value="1">Activo</option>
                                    <option value="2">Inactvo</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group container" style="margin-left: 290px;">
                            <label class="col-md-4 control-label">Los campos con * son obligatorios</label>
                        </div>


                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-4">
                            <input type="submit" class="btn btn-default" id="registrar" name="accion" value="Registrar" />
                            <button type="button" class="btn btn-default">Buscar</button>
                            <button type="button" class="btn btn-default">Modificar</button>
                            <button type="button" class="btn btn-default">Eliminar</button> 
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
