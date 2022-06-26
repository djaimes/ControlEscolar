/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package datos;

import domain.AlumnoEntidad;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface para la entidad alumnos
 * 
 * @author dajaimes
 */
public interface IAlumnoDatos {
    public List<AlumnoEntidad> seleccionar() throws SQLException;
    public int insertar(AlumnoEntidad alumno) throws SQLException;
    public int eliminar(AlumnoEntidad alumno) throws SQLException;
    public AlumnoEntidad buscar(AlumnoEntidad alumno) throws SQLException;
    public int actualizar(AlumnoEntidad alumno) throws SQLException;
}
