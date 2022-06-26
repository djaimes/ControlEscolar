/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package domain;

/**
 * Clase entidad para la tabla alumno
 * Dominio del problema
 * @author dajaimes
 */
public class AlumnoEntidad {
    
    // Atributos de la tabla alumnos
    private int id;
    private int activo;
    private double promedio;
    private String nombre;
    private String paterno;
    private String materno;
    private String matricula;
    private String correo;
    private String sexo;

    // Constructor vacío
    public AlumnoEntidad() {
    }

    // Constructor con todos los campos
    public AlumnoEntidad(int id, int activo, double promedio, String nombre, String paterno, String materno, String matricula, String correo, String sexo) {
        this.id = id;
        this.activo = activo;
        this.promedio = promedio;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.matricula = matricula;
        this.correo = correo;
        this.sexo = sexo;
    }

    // Constructor para INSERT
    public AlumnoEntidad(int activo, double promedio, String nombre, String paterno, String materno, String matricula, String correo, String sexo) {
        this.activo = activo;
        this.promedio = promedio;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.matricula = matricula;
        this.correo = correo;
        this.sexo = sexo;
    }

    // Constructor para DELETE o BUSCAR
    public AlumnoEntidad(int id) {
        this.id = id;
    } 
    
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "AlumnoEntidad{" + "id=" + id + ", activo=" + activo + ", promedio=" + promedio + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", matricula=" + matricula + ", correo=" + correo + ", sexo=" + sexo + '}';
    }
    
}
