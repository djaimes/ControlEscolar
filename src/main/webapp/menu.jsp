<%-- 
    Document   : index
    Created on : 2/11/2020, 09:52:30 AM
    Author     : dajaimes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!--script src="/ControlEscolar/public/js/controlescolarajax.js" charset="utf-8"></script -->
        
        <script src="https://kit.fontawesome.com/f97f12f562.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="/ControlEscolar/public/css/controlescolar.css" class="rel">
        <link href="https://fonts.googleapis.com/css?family=Be+Vietnam&display=swap" rel="stylesheet">
        
        <title>Control Escolar</title>
    </head>
    <body>
        <!-- Validar sesión -->
        <div class="contenedor-menu">
            <a href="#" class="btn-menu">MENÚ PRINCIPAL</a>
            <ul class="menu">
                <li>
                    <a href="${pageContext.request.contextPath}/ServletAlumno?accion=listar">
                        <i class="icono left fas fa-user-graduate"></i>
                        Alumnos
                        <i class="icono right fas fa-angle-right"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="icono left fas fa-chalkboard-teacher"></i>
                        Profesores
                        <i class="icono right fas fa-angle-right"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="icono left fas fa-chart-bar"></i>
                        Estadística
                        <i class="icono right fas fa-angle-right"></i>
                    </a>
                    <ul>
                        <li><a href="#">Indicadores</a></li>
                        <li><a href="#">Promedios</a></li>
                        <li><a href="#">Percentiles</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/ServletUsuario?accion=salir">
                        <i class="icono left fas fa-sign-out-alt"></i>
                        Salir
                    </a>
                </li>
            </ul>
        </div>
        <div id="contenido">

        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </body>
</html>
