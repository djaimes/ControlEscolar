/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para conexión a base de datos
 * 
 * @author dajaimes
 */

public class Conexion {

    private static Connection conn = null;
    
    private static final String URL = "jdbc:mysql://localhost:3306/"
            + "controlescolar?"
            + "useSSL=false"
            + "&useTimezone=true"
            + "&serverTimezone=UTC"
            + "&allowPublickeyRetrieval=true";
        
    private static final String USUARIO = "admince";
    private static final String PASSWORD = "Admince_2103";

    public static Connection getConnection() {
        try {
            conn =  DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }
        catch (SQLException ex) {
            System.out.println("NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex.getMessage());
        }
        return conn;
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }

    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
}