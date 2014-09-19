<%-- 
    Document   : Inicio
    Created on : 10-mar-2014, 12:00:58
    Author     : daniel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link href='http://fonts.googleapis.com/css?family=Playfair+Display+SC' rel='stylesheet' type='text/css'>
        <style>
            h1 {
                text-align: center;
                color: black;
                font-family: 'Playfair Display SC', serif;
            }  

        </style>
        <script src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
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
                        $("#Ges_usuario").addClass(hide);
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
                            <li><a href="index.html">Salir</a></li>
                        </ul>

                    </div> <!-- Fin Barra Colapsada -->

                </div>
            </nav>

            <!-- Comienzo del contenido interno de la página -->
            <div class="container">

            </div>
        </div>

    </body>
</html>
