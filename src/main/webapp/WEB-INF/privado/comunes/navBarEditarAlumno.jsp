<%-- 
    Document   : navBarEditarAlumno
    Created on : 10/11/2020, 05:40:59 PM
    Author     : dajaimes
--%>

<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <!<!-- Regresar... -->
            <div class="col-md-3">
                <a href="alumnos.jsp" class="btn bg-light btn-block">
                    <i class="fas fa-arrow-left"></i>Regresar
                </a>
            </div>
            <!<!-- Actualizar... -->
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar
                </button>
            </div>
            <!<!-- Borrar alumno se procesa en doGET-->
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletAlumno?accion=eliminar&id=${alumno.id}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar
                </a>
            </div>
        </div>
    </div>
    
</section>
