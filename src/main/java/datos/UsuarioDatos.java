/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package datos;

import domain.UsuarioEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dajaimes
 */
public class UsuarioDatos implements IUsuarioDatos {

    private static final String SQLSELECTPORID = "SELECT id, login, password,"
            + "nombre, paterno, materno, sexo, correo, codigo, activo, perfil, alta "
            + "FROM usuarios WHERE login = ? and password = ?";

    @Override
    public UsuarioEntidad buscar(UsuarioEntidad usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQLSELECTPORID);

        // Sustituimos las incógnitas de la cadena SQLSELECTPORID
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getPassword());

        rs = stmt.executeQuery();

        if (rs.next()) {
            
            int id = rs.getInt("id");

            //  Usar el objeto alumno del parámetro para devolver valores
            usuario.setId(id);
            usuario.setLogin(rs.getString("login"));
            usuario.setPassword(rs.getString("password"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setPaterno(rs.getString("paterno"));
            usuario.setMaterno(rs.getString("materno"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setCodigo(rs.getString("codigo"));
            usuario.setActivo(rs.getInt("activo"));
            usuario.setPerfil(rs.getInt("perfil"));
            usuario.setAlta(rs.getDate("alta"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return usuario;
    }
}
