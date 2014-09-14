<%-- 
    Document   : Login
    Created on : 29-mar-2014, 20:24:19
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String user = request.getAttribute("user") != null ? (String) request.getAttribute("user") : "";
    String pass = request.getAttribute("pass") != null ? (String) request.getAttribute("pass") : "";
    String perfil = request.getAttribute("perfil") != null ? (String) request.getAttribute("perfil") : "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                user = cookie.getValue();
            }
            if ( cookie.getName().equals("perfil") ){
                perfil = cookie.getValue();
            }
        }
    }
    if (user == null) {
        response.sendRedirect("login.html");
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
        <title>Acceso al Sistema</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <style>
            body    {
                background: url("../images/Fond.jpg");
                -webkit-background-size: cover;         
                -moz-background-size: cover;         
                -o-background-size: cover;         
                background-size: cover;
            }
            .page-header {
                border-bottom: 1px solid #FFFFFF;
                margin: 20px 0;
                padding-bottom: 9px;
                text-align: center;
            }

            .form-control {
                border: 1px solid #D6D6D6;
                border-radius: 0;
                box-shadow: none;
                height: 50px;
                padding: 6px 15px;
            }      

            .row {
                background: #ededed;
                padding: 20px 50px 20px 50px;
                margin: 100px;
            }

            legend {
                border: medium none;
                color: #7F7F7F;
                display: block;
                font-size: 20px;
                line-height: inherit;
                margin-bottom: 15px;
                padding: 0;
                text-align: center;
                width: 100%;
            }

            .btn {
                padding: 10px;
                border-radius: 0;
                border: none;
                font-size: 21px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="page-header"><h2>Acceso al Sistema</h2></div>
                <form class="form-horizontal"  action="LoginServlet" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend><h3>Ingresar</h3></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-1 control-label" for="username"></label>  
                            <div class="col-md-12">
                                <input id="user" name="user" type="text" placeholder="Usuario" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-1 control-label" for="password"></label>
                            <div class="col-md-12">
                                <input id="pass" name="pass" type="password" placeholder="Contraseña" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Button (Double) -->
                        <div class="form-group">
                            <label class="col-md-1 control-label" for="login"></label>
                            <div class="col-md-5">
                                <input type="submit" name="accion" id="btningresar" Value="Ingresar" class="btn btn-block btn-success" />
                            </div>
                            <div class="col-md-5">
                                <a id="forpass" name="forpass" class="btn btn-block btn-warning" href="index.html">Cancelar</a>
                            </div>  
                        </div>
                    </fieldset>
                </form>
            </div> <!--./row -->
        </div> <!--./container -->
    </body>
</html>
