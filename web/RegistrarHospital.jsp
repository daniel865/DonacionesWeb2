<%-- 
    Document   : RegistrarHospital
    Created on : 19-mar-2014, 11:16:39
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%
        String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
        String tipo = request.getAttribute("tipo") != null ? (String) request.getAttribute("tipo") : "";
        String nit = request.getAttribute("nit") != null ? (String) request.getAttribute("nit") : "";
        String razon = request.getAttribute("razon") != null ? (String) request.getAttribute("razon") : "";
        String direccion = request.getAttribute("direccion") != null ? (String) request.getAttribute("direccion") : "";
        String departamento = request.getAttribute("departamento") != null ? (String) request.getAttribute("departamento") : "";
        String municipio = request.getAttribute("municipio") != null ? (String) request.getAttribute("municipio") : "";
        String telefono = request.getAttribute("telefono") != null ? (String) request.getAttribute("telefono") : "";
        String representante = request.getAttribute("representante") != null ? (String) request.getAttribute("representante") : "";
        String tel_representante = request.getAttribute("tel_representante") != null ? (String) request.getAttribute("tel_representante") : "";
        String correo_representante = request.getAttribute("correo_representante") != null ? (String) request.getAttribute("correo_representante") : "";
        String nivel = request.getAttribute("nivel") != null ? (String) request.getAttribute("nivel") : "";
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

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Hospital</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrapValidator.js"></script>
        <script type="text/javascript" src="js/validateHospital.js"></script>
        <script type="text/javascript" src="js/Listas.js"></script>

    </head>
    <body>

        <%if (mensaje != null) {%>
        <script>
        $(document).ready(function () {
            var tipo = '<%=tipo%>';
            var departamento = '<%=departamento%>';
            var municipio = '<%=municipio%>';
            var nivel = '<%=nivel%>';
            var estado = '<%=estado%>';
            $("#tipo option[value="+tipo+"]").attr("selected", true);
            $("#departamento option[value="+2+"]").attr("selected", true);
            $("#municipio option[value="+82+"]").attr("selected", true);
            $("#nivel option[value="+nivel+"]").attr("selected", true);
            $("#estado option[value="+estado+"]").attr("selected", true);
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
                                <input id="nit" name="nit" type="text" placeholder="" class="form-control input-md" value="<%=nit%>" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="razon">Razón Social*</label>  
                            <div class="col-md-4 input-group">
                                <input id="razon" name="razon" type="text" placeholder="" class="form-control input-md" value="<%=razon%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección*</label>  
                            <div class="col-md-4 input-group">
                                <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-md" value="<%=direccion%>" >
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="departamento">Departamento*</label>
                            <div class="col-md-4 input-group">
                                <select id="departamento" name="departamento" class="form-control input-md" >
                                    <option value="">Seleccione un Departamento</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="municipio">Municipio* </label>
                            <div class="col-md-4 input-group">
                                <select id="municipio" name="municipio" class="form-control input-md">
                                    <option value="">Seleccione un Municipio</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono*</label>  
                            <div class="col-md-4 input-group">
                                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md" value="<%=telefono%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="representante">Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="representante" name="representante" type="text" placeholder="" class="form-control input-md" value="<%=representante%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="tel_representante">Teléfono Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="tel_representante" name="tel_representante" type="text" placeholder="" class="form-control input-md" value="<%=tel_representante%>">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="correo_representante">Correo Representante*</label>  
                            <div class="col-md-4 input-group">
                                <input id="correo_representante" name="correo_representante" type="text" placeholder="" class="form-control input-md" value="<%=correo_representante%>">
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
                                    <li><a href="#" data-toggle="modal" data-target="#ModalBuscar">NIT</a></li>
                                    <li><a href="#" data-toggle="modal" data-target="#ModalConsultar">Razón Social</a></li>
                                </ul>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Modificar" id="btnmodificar" style="margin-left: 10px;" /> 
                            <button type="reset" class="btn btn-primary" name="btnlimpiar" id="btnlimpiar" style="margin-left: 10px;">Limpiar</button>

                        </div>

                    </fieldset>
                </form>


                <!-- Modal Buscar-->
                <form class="form-horizontal" action="HospitalServlet" method="POST" >
                    <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Hospital</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">NIT</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_usu" name="buscar_hos" placeholder="" class="form-control input-md"  type="text">
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
                <form class="form-horizontal" action="HospitalServlet" method="POST" >
                    <div class="modal fade" id="ModalConsultar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Buscar Usuario</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buscar">Razón Social</label>  
                                        <div class="col-md-4">
                                            <input id="buscar_usu" name="buscar_hos" placeholder="" class="form-control input-md"  type="text">
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
