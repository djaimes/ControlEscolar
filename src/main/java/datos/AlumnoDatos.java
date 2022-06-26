/* 
 * UNIVERSIDAD AUTÓNOMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package datos;

import domain.AlumnoEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa los métodos de listar, insertar, actualizar y borrar De la entidad
 * alumno
 *
 * @author dajaimes
 */
public class AlumnoDatos implements IAlumnoDatos {

// Atributos para los querys
    private static final String SQLSELECT = "SELECT id, activo, promedio,"
            + "nombre, paterno, materno, matricula, correo, sexo "
            + "FROM alumnos";

    private static final String SQLSELECTPORID = "SELECT id, activo, promedio,"
            + "nombre, paterno, materno, matricula, correo, sexo "
            + "FROM alumnos WHERE id = ? ";

    private static final String SQLINSERT = "INSERT INTO alumnos(activo, promedio,"
            + "nombre, paterno, materno, matricula, correo, sexo)"
            + "VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQLUPDATE = "UPDATE alumnos "
            + "SET activo = ?, promedio = ?, nombre = ?, paterno=?, materno=?,"
            + "matricula = ?, correo = ?, sexo = ?"
            + "WHERE id = ?";

    private static final String SQLDELETE = "DELETE FROM alumnos WHERE id=?";

    @Override
    public List<AlumnoEntidad> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AlumnoEntidad alumno = null;
        List<AlumnoEntidad> alumnos = new ArrayList<>();     

        try {
            conn = Conexion.getConnection();                
            stmt = conn.prepareStatement(SQLSELECT);        
            rs = stmt.executeQuery();              

            while (rs.next()) {                 // Recorremos el RecorSet
                int id = rs.getInt("id");       
                int activo = rs.getInt("activo");
                
                double promedio = rs.getDouble("promedio");
                
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String matricula = rs.getString("matricula");
                String correo = rs.getString("correo");
                String sexo = rs.getString("sexo");

                //  Crear el objeto alumno
                alumno = new AlumnoEntidad(id, activo, promedio, nombre, paterno,
                        materno, matricula, correo, sexo);
                
                // Agregar el alumno a la Lista de alumnos
                alumnos.add(alumno);    
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        rs.close();
        stmt.close();
        conn.close();
        return alumnos;
    }

    @Override
    public AlumnoEntidad buscar(AlumnoEntidad alumno) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();               
            stmt = conn.prepareStatement(SQLSELECTPORID);     

            // (1,1) el primer 1 es la primera interrogación, el 2o es alumnoID
            stmt.setInt(1, alumno.getId());
            rs = stmt.executeQuery();  

            if (rs.next()) {
                int activo = rs.getInt("activo");
                double promedio = rs.getDouble("promedio");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String matricula = rs.getString("matricula");
                String correo = rs.getString("correo");
                String sexo = rs.getString("sexo");

                //  Usar el objeto alumno del parámetro para devolver valores
                alumno.setActivo(activo);
                alumno.setCorreo(correo);
                alumno.setNombre(nombre);
                alumno.setMaterno(materno);
                alumno.setPaterno(paterno);
                alumno.setPromedio(promedio);
                alumno.setSexo(sexo);
                alumno.setMatricula(matricula);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {           // los bloques finally siempre se ejecutan
            rs.close();
            stmt.close();
            conn.close();
        }
        return alumno;
    }

    @Override
    public int insertar(AlumnoEntidad alumno) throws SQLException {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();
            
            stmt = conn.prepareStatement(SQLINSERT); 
            stmt.setInt(1, alumno.getActivo());
            stmt.setDouble(2, alumno.getPromedio());
            stmt.setString(3, alumno.getNombre());
            stmt.setString(4, alumno.getPaterno());
            stmt.setString(5, alumno.getMaterno());
            stmt.setString(6, alumno.getMatricula());
            stmt.setString(7, alumno.getCorreo());
            stmt.setString(8, alumno.getSexo());
            
            filasAfectadas = stmt.executeUpdate();  
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {           
            stmt.close();
            conn.close();
        }
        return filasAfectadas;    
    }

    @Override
    public int actualizar(AlumnoEntidad alumno) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();             
            
            stmt = conn.prepareStatement(SQLUPDATE);
            stmt.setInt(1, alumno.getActivo());
            stmt.setDouble(2, alumno.getPromedio());
            stmt.setString(3, alumno.getNombre());
            stmt.setString(4, alumno.getPaterno());
            stmt.setString(5, alumno.getMaterno());
            stmt.setString(6, alumno.getMatricula());
            stmt.setString(7, alumno.getCorreo());
            stmt.setString(8, alumno.getSexo());
            stmt.setInt(9, alumno.getId());
            
            filasAfectadas = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            stmt.close();
            conn.close();
        }
        return filasAfectadas;  
    }
    
    @Override
    public int eliminar(AlumnoEntidad alumno) throws SQLException {
                
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();             
            
            stmt = conn.prepareStatement(SQLDELETE);     
            stmt.setInt(1, alumno.getId());
            
            filasAfectadas = stmt.executeUpdate(); 
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {        
            stmt.close();
            conn.close();
        }
        return filasAfectadas;  
    }
}
