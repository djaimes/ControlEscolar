<%-- 
    Document   : editarAlumno
    Created on : 10/11/2020, 05:34:53 PM
    Author     : dajaimes
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <!-- Font awesome  -->
        <script src="https://kit.fontawesome.com/f97f12f562.js" crossorigin="anonymous"></script>

        <title>Editar alumno</title>
    </head>
    <body>
        <!-- Encabezado -->
        <jsp:include page="/WEB-INF/privado/comunes/encabezadoPagina.jsp" />

        <!<!-- formulario para enviar los datos modificados al servidor -->
        <form action="${pageContext.request.contextPath}/ServletAlumno?accion=modificar&id=${alumno.id}"
              method="post" class="was-validated">

            <!-- Barra de nav para editar alumno -->
            <jsp:include page="/WEB-INF/privado/comunes/navBarEditarAlumno.jsp" />

            <section id="detalle">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Alumno</h4>
                                </div>
                                <div class="card-body">
                                    <!-- Agregar los campos de alumno -->
                                    <!-- Campos de la entidad Alumno del registro actual -->
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${alumno.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="paterno">Paterno</label>
                                        <input type="text" class="form-control" name="paterno"  value="${alumno.paterno}">
                                    </div>
                                    <div class="form-group">
                                        <label for="materno">Materno</label>
                                        <input type="text" class="form-control" name="materno"  value="${alumno.materno}">
                                    </div>
                                    <div class="form-group">
                                        <label for="matricula">Matrícula</label>
                                        <input type="text" class="form-control" name="matricula" required value="${alumno.matricula}">
                                    </div>
                                    <div class="form-group">
                                        <label for="promedio">Promedio</label>
                                        <input type="number" step="any" class="form-control" name="promedio" required value=${alumno.promedio}>
                                    </div>
                                    <div class="form-group">
                                        <label for="correo">Correo</label>
                                        <input type="email" class="form-control" name="correo" required value="${alumno.correo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="sexo">Sexo</label>
                                        <input type="text" class="form-control" name="sexo" value="${alumno.sexo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="activo">Activo</label>
                                        <input type="number" class="form-control" name="activo" value=${alumno.activo}>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <!-- Footer -->
        <jsp:include page="/WEB-INF/privado/comunes/piePagina.jsp" />

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

    </body>
</html>
