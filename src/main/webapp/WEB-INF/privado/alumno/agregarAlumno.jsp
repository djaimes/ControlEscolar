<%-- 
    Document   : agregarAumno
    Created on : 9/11/2020, 11:27:00 AM
    Author     : dajaimes
--%>
<div class="modal fade" id="agregarAlumno">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Alumno</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <!-- Para que se llame la acción insertar con POST -->
            <form action="${pageContext.request.contextPath}/ServletAlumno?accion=agregar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <!-- Campos de la entidad Alumno -->
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="paterno">Paterno</label>
                        <input type="text" class="form-control" name="paterno">
                    </div>
                    <div class="form-group">
                        <label for="materno">Materno</label>
                        <input type="text" class="form-control" name="materno">
                    </div>
                    <div class="form-group">
                        <label for="matricula">Matrícula</label>
                        <input type="text" class="form-control" name="matricula" required>
                    </div>
                    <div class="form-group">
                        <label for="promedio">Promedio</label>
                        <input type="number" step="any" class="form-control" name="promedio" required>
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" name="correo" required>
                    </div>
                    <div class="form-group">
                        <label for="sexo">Sexo</label>
                        <input type="text" class="form-control" name="sexo">
                    </div>
                    <div class="form-group">
                        <label for="activo">Activo</label>
                        <input type="number" class="form-control" name="activo" value="1">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>