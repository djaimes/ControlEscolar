/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package pruebas;

import domain.AlumnoEntidad;
import negocio.AlumnoAdministrar;
import negocio.IAlumnoAdministrar;

/**
 *
 * @author dajaimes
 */
public class AlumnoProbar {

    public static void main(String[] args) {
        IAlumnoAdministrar alumno = new AlumnoAdministrar();

        // Estos datos vendrán del JSP cliente
        AlumnoEntidad alumnoDeHTML = new AlumnoEntidad();

        // SELECT
        
         alumno.seleccionarAlumnno(alumnoDeHTML);
        
        // PROBANDO Buscar por ID
        
         alumnoDeHTML.setId(3);
         alumno.buscarAlumnno(alumnoDeHTML);
         
        // INSERT 
        
        alumnoDeHTML.setActivo(1);
        alumnoDeHTML.setCorreo("al061620@uacam.mx");
        alumnoDeHTML.setMaterno("ALDANA");
        alumnoDeHTML.setMatricula("61620");
        alumnoDeHTML.setNombre("MIGUEL ADRIÁN");
        alumnoDeHTML.setPaterno("BARBOSA");
        alumnoDeHTML.setPromedio(9.3);
        alumnoDeHTML.setSexo("H");
        
        alumno.agregarAlumno(alumnoDeHTML);
        
        // DELETE 
       
        alumnoDeHTML.setId(3);
        alumno.eliminarAlumno(alumnoDeHTML);
        
        // UPDATE
        alumnoDeHTML.setId(4);
        alumnoDeHTML.setActivo(1);
        alumnoDeHTML.setCorreo("al060881@uacam.mx");
        alumnoDeHTML.setMaterno("CANUL");
        alumnoDeHTML.setMatricula("60881");
        alumnoDeHTML.setNombre("JESÚS ABRAHAM");
        alumnoDeHTML.setPaterno("NAVARRETE");
        alumnoDeHTML.setPromedio(8.3);
        alumnoDeHTML.setSexo("H");
        alumno.actualizarAlumno(alumnoDeHTML);
        
    }
}
