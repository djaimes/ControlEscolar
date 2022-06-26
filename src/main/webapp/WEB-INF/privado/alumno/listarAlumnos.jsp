<%-- 
    Document   : listarAlumnos
    Created on : 8/11/2020, 07:05:19 PM
    Author     : dajaimes
--%>
<%-- Librería de core para JSP --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Librería para formatear cantidades en HTML --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_MX" />


<section id="alumnos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de alumnos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Matrícula</th>
                                <th>Nombre</th>
                                <th>Promedio</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Recorremos el listado -->
                            <c:forEach var="alumno" items="${alumnos}">
                                <tr>
                                    <td>${alumno.matricula}</td>
                                    <td>${alumno.nombre} ${alumno.paterno} ${alumno.materno}</td>
                                    <td><fmt:formatNumber value= "${alumno.promedio}" type="number" minFractionDigits="1" /></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletAlumno?accion=editar&id=${alumno.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-right"></i> Editar
                                    </td>
                                </tr>
                            </c:forEach>
                                
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- INICIA: Espacio para poner estadísticas -->
            <div class="col-md-3">
                <div class="card text-center bg-light text-black mb-3">
                    <div class="card-body">
                        <h3>Promedio general</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value= "${promedioGeneral}" type="number" minFractionDigits="2"
                                              maxFractionDigits="2" />
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-light text-black mb-3">
                    <div class="card-body">
                        <h3>Desviación Estándar</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value= "${desviacionEstandarGeneral}" type="number" 
                                              minFractionDigits="2" maxFractionDigits="2" />
                        </h4>
                    </div>
                </div>
            </div>
            <!-- TERMINA: Espacio para poner estadísticas -->
        </div>
    </div>
</section>

<!-- Agregar alumno -->
<jsp:include page="/WEB-INF/privado/alumno/agregarAlumno.jsp" />