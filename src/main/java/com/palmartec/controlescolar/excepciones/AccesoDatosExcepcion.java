/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package com.palmartec.controlescolar.excepciones;

/**
 * Clase madre para el manejo de excepciones
 * 
 * @author dajaimes
 * 
 */
public class AccesoDatosExcepcion extends Exception {

    public AccesoDatosExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
