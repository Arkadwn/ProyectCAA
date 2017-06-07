package reglasnegocio.usuariogeneral;

import java.io.IOException;
import reglasnegocio.entidades.Usuario;
import java.sql.SQLException;

/**
 * Especifica los metodos para la autentificacion de usuarios.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IUsuarioDAO {
    public boolean autentificarUsuario(String usuario, String contrasena)throws SQLException,IOException;
    public String cifrarContrasena(String contrasena)throws SQLException, IOException;
    public Usuario sacarDatosUsuario(String nombreUsuario)throws SQLException,IOException;
}
