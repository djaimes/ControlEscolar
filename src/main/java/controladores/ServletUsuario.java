/* 
 * UNIVERSIDAD AUTÓNOMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package controladores;

import datos.IUsuarioDatos;
import datos.UsuarioDatos;
import domain.UsuarioEntidad;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dajaimes
 */
@WebServlet("/ServletUsuario")

public class ServletUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "salir":

                // destruir la sesion
                HttpSession sesion = request.getSession();
                sesion.invalidate();

                response.sendRedirect("index.jsp");
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "ingresar": {
                try {
                    // Validar usuario y generar session y mandar al menú
                    this.buscarUsuario(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }

            break;

            default:
                throw new AssertionError();
        }
    }

    // Esta clase es como un servlet secundario
    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        // Modelo (M)
        
        UsuarioEntidad usuarioE = new UsuarioEntidad(login, password);
        IUsuarioDatos usuarioD = new UsuarioDatos();

        usuarioE = usuarioD.buscar(usuarioE);

        if (usuarioE.getNombre() == null) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("menu.jsp");
        }

        System.out.println("usuarioE = " + usuarioE);
    }

    public void validarSesion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        // Activar variables de sesión para autenticación
        response.setContentType("text/html;charset=UTF-8");

        // Crear o consultar si hay una session
        HttpSession sesion = request.getSession();

        // Variables de sesión
        if (sesion.getAttribute("nombre") == null) {
            System.out.println("NO Hay sesion");
            response.sendRedirect("menu.jsp");
        } else {
            sesion.setAttribute("nombre", "logeado");

        response.sendRedirect("menu.jsp");
        }
    }
}
