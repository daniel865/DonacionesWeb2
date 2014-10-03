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
    String segundo_apellido = request.getAttribute("segundo_apellido") != null ? (String) request.getAttribute("segundo_apellido") : "";
    String telefono = request.getAttribute("telefono") != null ? (String) request.getAttribute("telefono") : "";
    String direccion = request.getAttribute("direccion") != null ? (String) request.getAttribute("direccion") : "";
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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Donante</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css"/>
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrapValidator.js"></script>
        <script type="text/javascript" src="js/validateDonante.js"></script>   
        <script src="js/Listas.js"></script>
    </head>
    <body>

        <%if (mensaje != null) {%>
        <script type="text/javascript">
    $(document).ready(function () {
        var tipo_doc = '<%=tipo_doc%>';
        var departamento = '<%=departamento%>';
        var departamento1 = departamento;
        console.log(departamento);
        var municipio = '<%=municipio%>';
        var municipio1 = municipio;
        console.log(municipio);
        var genero = '<%=genero%>';
        var enfermedades = '<%=enfermedades%>';
        var habitos = '<%=habitos%>';
        var estado = '<%=estado%>';
        $("#tipo_doc option[value=" + tipo_doc + "]").attr("selected", true);
        /*
         $("#departamento option[value='']").attr("selected", true);
         $("#departamento option[value=" + 2 + "]").attr("selected", true);
         */
        //$("#municipio option[value=" + 82 + "]").attr("selected", true);
        $("#genero option[value=" + genero + "]").attr("selected", true);
        $("#enfermedades option[value=" + enfermedades + "]").attr("selected", true);
        $("#habitos option[value=" + habitos + "]").attr("selected", true);
        $("#estado option[value=" + estado + "]").attr("selected", true);
    });

        </script>
        <%}%>   

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
        <script>
            $(document).ready(getList('D', function (values) {
                for (var idx in values) {
                    $('#departamento').append('<option value=' + values[idx].id + '>' + values[idx].nombre + '</option>');
                }
            }));
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

            <br/>

            <div class="container">
                <form class="form-horizontal" action="DonanteServlet" id="FormDonante" name="FormDonante">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Gestionar Donantes</legend>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tipo_doc">Tipo de Documento</label>
                            <div class="col-md-4 input-group">
                                <select id="tipo_doc" name="tipo_doc" class="form-control">
                                    <option value="">Selecciona una opción</option>
                                    <option value="1">Tarjeta de Identidad</option>
                                    <option value="2">Cédula de Ciudadanía</option>
                                    <option value="3">Cédula de Extranjería</option>
                                    <option value="4">Pasaporte</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nro_doc">Número de Documento</label>  
                            <div class="col-md-4 input-group">
                                <input id="nro_doc" name="nro_doc" type="text" placeholder="" class="form-control input-md" required="" value="<%=nro_doc%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombres">Nombres</label>  
                            <div class="col-md-4 input-group">
                                <input id="nombres" name="nombres" type="text" placeholder="" class="form-control input-md" required="" value="<%=nombres%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="primer_apellido">Primer Apellido</label>  
                            <div class="col-md-4 input-group">
                                <input id="primer_apellido" name="primer_apellido" type="text" placeholder="" class="form-control input-md" required="" value="<%=primer_apellido%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="segundo_apellido">Segundo Apellido</label>  
                            <div class="col-md-4 input-group">
                                <input id="segundo_apellido" name="segundo_apellido" type="text" placeholder="" class="form-control input-md" value="<%=segundo_apellido%>" >
                            </div>
                        </div>


                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono </label>  
                            <div class="col-md-4 input-group">
                                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md" value="<%=telefono%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                            <div class="col-md-4 input-group">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md" required="" value="<%=direccion%>">
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento*</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control">
                                    <option value="">Seleccione un Departamento</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="municipio">Municipio*</label>
                            <div class="col-md-4 input-group">
                                <select id="municipio" name="municipio" class="form-control">
                                    <option value="">Seleccione un Municipio</option>
                                </select>

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="genero">Género</label>
                            <div class="col-md-4 input-group">
                                <select id="genero" name="genero" class="form-control input-md">
                                    <option value="">Selecciona una opción</option>
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo">Correo Electrónico</label>  
                            <div class="col-md-4 input-group">
                                <input id="correo" name="correo" type="text" placeholder="" class="form-control input-md" value="<%=correo%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fecha_nacimiento">Fecha de Nacimiento</label>  
                            <div class="col-md-4 input-group">
                                <input id="fecha_nacimiento" name="fecha_nacimiento" type="date" class="form-control input-md" value="<%=fecha_nacimiento%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="fec_ultdonacion">Fecha Última Donación</label>  
                            <div class="col-md-4 input-group">
                                <input id="fec_ultdonacion" name="fec_ultdonacion" type="date"  class="form-control input-md" value="<%=fec_ultdonacion%>">
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="enfermedades">Enfermedades</label>
                            <div class="col-md-4 input-group">
                                <select id="enfermedades" name="enfermedades" class="form-control input-md">
                                    <option value="">Selecciona una opción</option>
                                    <option value="1">Ninguna</option>
                                    <option value="2">Hepatitis A</option>
                                    <option value="3">Hepatitis B</option>
                                    <option value="4">Cáncer</option>
                                    <option value="5">Sida</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="habitos">Hábitos</label>
                            <div class="col-md-4 input-group">
                                <select id="habitos" name="habitos" class="form-control input-md">
                                    <option value="">Selecciona una opción</option>
                                    <option value="2">Ninguno</option>
                                    <option value="3">Fumar</option>
                                    <option value="4">Drogas</option>
                                    <option value="5">Alcohol</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nom_responsable">Nombre Responsable</label>  
                            <div class="col-md-4 input-group">
                                <input id="nom_responsable" name="nom_responsable" type="text" placeholder="" class="form-control input-md" value="<%=nom_responsable%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tel_responsable">Teléfono Responsable</label>  
                            <div class="col-md-4 input-group">
                                <input id="tel_responsable" name="tel_responsable" type="text" placeholder="" class="form-control input-md" value="<%=tel_responsable%>">
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado</label>
                            <div class="col-md-4 input-group">
                                <select id="estado" name="estado" class="form-control input-md">
                                    <option value="">Selecciona una opción</option>
                                    <option value="1">Activo</option>
                                    <option value="2">Inactivo</option>
                                </select>
                            </div>
                        </div>


                        <!-- Groups Buttons -->
                        <div class="btn-group col-lg-offset-4 col-lg-5">
                            <input type="submit" class="btn btn-primary" name="accion" value="Guardar" id="btnguardar" style="margin-left: 10px;"/>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar" style="margin-left: 10px;">Consultar</button>
                            <input type="submit" class="btn btn-primary" name="accion" value="Modificar" id="btnmodificar" style="margin-left: 10px;"/> 
                            <button type="reset" class="btn btn-primary" name="btnlimpiar" id="btnlimpiar" style="margin-left: 10px;">Limpiar</button>
                        </div>

                    </fieldset>
                </form>

                <!-- Modal Buscar-->
                <form class="form-horizontal" action="DonanteServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Donante</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Número de Documento de Identificación</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_jor" name="buscar_don" placeholder="" class="form-control input-md"  type="text">
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

                <br/>
                <br/>
                <br/>


            </div>    

        </div>
    </body>

    <script>
        $('#departamento').change(function () {
            $('#municipio').empty();
            var departamento = $('#departamento').val();
            getList('M', function (values) {
                for (var idx in values) {
                    $('#municipio').append('<option value=' + values[idx].id + '>' + values[idx].nombre + '</option>');
                }
            }, departamento);
        });

    </script>
</html>
