/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package negocio;

import domain.AlumnoEntidad;

/**
 * Capa de alumnos para la lógica el negocio
 * Aquí van los métodos que utiliza el usuario final
 * 
 * @author dajaimes
 */
public interface IAlumnoAdministrar {
    
    void seleccionarAlumnno(AlumnoEntidad alumno);
    void buscarAlumnno(AlumnoEntidad alumno);
    int agregarAlumno(AlumnoEntidad alumno);
    int eliminarAlumno(AlumnoEntidad alumno);
    int actualizarAlumno(AlumnoEntidad alumno);
}
