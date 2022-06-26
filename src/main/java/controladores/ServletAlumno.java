/* 
 * UNIVERSIDAD AUTÓNOMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package controladores;

import datos.AlumnoDatos;
import datos.IAlumnoDatos;
import domain.AlumnoEntidad;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Front Controller de MVC
 *
 * @author dajaimes
 */
@WebServlet("/ServletAlumno")

public class ServletAlumno extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "editar": {
                try {
                    this.editarAlumno(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            break;

            case "eliminar":
                try {
                this.eliminarAlumno(request, response);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            break;

            case "listar":
                try {
                this.listarAlumno(request, response);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            break;
            default: {
                try {
                    this.listarAlumno(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
    }


    private void editarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Leer el id del navegador
        int id = Integer.parseInt(request.getParameter("id"));

        // Modelo (M) - Recuperar los valores del alumno de la BD
        IAlumnoDatos alumnoD = new AlumnoDatos();
        AlumnoEntidad alumnoE = new AlumnoEntidad(id);

        alumnoE = alumnoD.buscar(alumnoE);

        // Compartir los datos del alumno en el sistema
        request.setAttribute("alumno", alumnoE);

        // Los datos obtenidos del registro seleccionado se desplegarán en el JSP
        String jspE = "/WEB-INF/privado/alumno/editarAlumno.jsp";
        request.getRequestDispatcher(jspE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregar": {
                try {
                    this.agregarAlumno(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            break;

            case "modificar":

                try {
                this.modificarAlumno(request, response);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            break;

            default: {
                try {
                    this.listarAlumno(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
    }
    
    // SELECT
    private void listarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Modelo
        IAlumnoDatos alumno = new AlumnoDatos();
        List<AlumnoEntidad> alumnos = new ArrayList<>();

        alumnos = alumno.seleccionar();

        // Calcular Promedio y Desviación Estándar de clase Estadística
        Estadistica estadistica = new Estadistica(alumnos);
        double promedioGeneral = estadistica.getMedia();
        double desviacionEstandarGeneral = estadistica.getDesviacionEstandar();

        
        // Compartir las variables con el JSP en el alcance de session
        HttpSession sesion = request.getSession();

        // Compartimos la información obtenida con otros módulos
        sesion.setAttribute("promedioGeneral", promedioGeneral);
        sesion.setAttribute("desviacionEstandarGeneral", desviacionEstandarGeneral);
        sesion.setAttribute("alumnos", alumnos);

        // Para evitar el reenvío del formulario y la duplicidad de registros
        response.sendRedirect("alumnos.jsp");
    }

    // INSERT
    private int agregarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Recuperamos los valores del formulario
        AlumnoEntidad alumnoForm = new AlumnoEntidad();

        alumnoForm.setNombre(request.getParameter("nombre"));
        alumnoForm.setPaterno(request.getParameter("paterno"));
        alumnoForm.setMaterno(request.getParameter("materno"));
        alumnoForm.setCorreo(request.getParameter("correo"));
        alumnoForm.setSexo(request.getParameter("sexo"));
        alumnoForm.setMatricula(request.getParameter("matricula"));

        double promedio = Double.parseDouble(request.getParameter("promedio"));
        alumnoForm.setPromedio(promedio);

        int activo = parseInt(request.getParameter("activo"));
        alumnoForm.setActivo(activo);

        // Modelo (DAO)
        IAlumnoDatos alumnoD = new AlumnoDatos();
        
        int rows = alumnoD.insertar(alumnoForm);

        // Actualizamos alumnos en el JSP (*)
        this.listarAlumno(request, response);

        return rows;
    }

    // UPDATE
    private int modificarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Recuperamos los valores del formulario
        AlumnoEntidad alumnoForm = new AlumnoEntidad();

        // Leer el id del navegador
        int id = Integer.parseInt(request.getParameter("id"));

        // Se requiere el Id por que se realizará un update
        alumnoForm.setId(id);

        alumnoForm.setNombre(request.getParameter("nombre"));
        alumnoForm.setPaterno(request.getParameter("paterno"));
        alumnoForm.setMaterno(request.getParameter("materno"));
        alumnoForm.setCorreo(request.getParameter("correo"));
        alumnoForm.setSexo(request.getParameter("sexo"));
        alumnoForm.setMatricula(request.getParameter("matricula"));

        double promedio = Double.parseDouble(request.getParameter("promedio"));
        alumnoForm.setPromedio(promedio);

        int activo = parseInt(request.getParameter("activo"));
        alumnoForm.setActivo(activo);

        // Actualizar el registro a la Base de Datos
        IAlumnoDatos alumnoD = new AlumnoDatos();
        
        // Acción
        int rows = alumnoD.actualizar(alumnoForm);

        // Actualizamos alumnos en el JSP
        this.listarAlumno(request, response);

        return rows;
    }

    // DELETE
    private int eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Recuperamos los valores del formulario
        AlumnoEntidad alumnoForm = new AlumnoEntidad();

        // Leer el id del navegador
        int id = Integer.parseInt(request.getParameter("id"));

        // Se requiere el Id por que será un update
        alumnoForm.setId(id);

        // Agregamos el registro a la Base de Datos
        IAlumnoDatos alumnoD = new AlumnoDatos();
        
        // Acción
        int rows = alumnoD.eliminar(alumnoForm);

        // Actualizamos alumnos en el JSP
        this.listarAlumno(request, response);

        return rows;
    }

}
