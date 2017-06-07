package reglasnegocio.usuariogeneral;

import reglasnegocio.entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IUsuarioDAO {
    public boolean autentificarUsuario(String usuario, String contrasena)throws SQLException;
    public String cifrarContrasena(String contrasena);
    public Usuario sacarDatosUsuario(String nombreUsuario)throws NullPointerException;
}
