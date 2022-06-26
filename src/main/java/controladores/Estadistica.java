/* 
 * UNIVERSIDAD AUTÓNOMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package controladores;

import domain.AlumnoEntidad;
import java.util.List;

/**
 *
 * @author dajaimes
 */
public class Estadistica {

    private double media;
    private double desviacionEstandar;
    private List<AlumnoEntidad> alumnos;

    public Estadistica(List<AlumnoEntidad> alumnos) {
        this.media = 0;
        this.desviacionEstandar = 0;
        this.alumnos = alumnos;
    }

    public double getMedia() {
        alumnos.forEach(alumno -> {
            this.media += alumno.getPromedio();
        });
        this.media /= alumnos.size();
        return this.media;
    }

    public double getDesviacionEstandar() {
        
        double cuadradoMedia = 0;
        double sumaCuadradosMedia = 0;

        for (AlumnoEntidad alumno : alumnos) {
            cuadradoMedia = Math.pow(Math.abs(alumno.getPromedio() - this.media), 2);
            sumaCuadradosMedia += cuadradoMedia;
        }

        this.desviacionEstandar = (sumaCuadradosMedia / this.alumnos.size());
        this.desviacionEstandar = Math.sqrt(this.desviacionEstandar);
        return this.desviacionEstandar;
    }
}