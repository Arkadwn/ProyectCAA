package reglasnegocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reglasnegocio.entidadesDAO.UsuarioDAO;
import reglasnegocio.entidades.Usuario;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class UsuarioDAOTest {
    
    private UsuarioDAO usuarioDAO;
    private String[] datosBD;
    
    public UsuarioDAOTest() {
        usuarioDAO = new UsuarioDAO();
        datosBD = new String[3];
    }
    

    /**
     * Pruena de un usuario incorrecto y una contraseña incorrecta.
     */
    @Test
    public void pruebaUsuarioYContraseñaCorrectos() {
        try {
            String usuario = "Leonardo";
            String contrasena = "acdc619mljj";
            boolean resultado = true;
            boolean confirmacion = usuarioDAO.autentificarUsuario(usuario, contrasena);
            assertEquals(resultado, confirmacion);
        } catch (IOException ex) {
            
        } catch (SQLException ex) {
            
        }
    }
    
    /**
     * Prueba de un usuario correcto y una contraseña incorrecta
     */
    @Test
    public void pruebaUsuarioCorrectoYContrasenaIncorrecto() throws SQLException, IOException {
        String usuario = "Adrian";
        String contrasena = "acdc619mljj";
        boolean resultado = false;
        boolean confirmacion = usuarioDAO.autentificarUsuario(usuario, contrasena);
        assertEquals(resultado, confirmacion);
    }
    
    /**
     * Prueba de seguridad contra inyeccion de codigo
     */
    @Test
    public void pruebaContraInyeccionDeCodigo() throws SQLException, IOException{
        String usuario = "'";
        String contrasena = "' or 1=1 ##";
        boolean resultado = false;
        boolean confirmacion = usuarioDAO.autentificarUsuario(usuario, contrasena);
        assertEquals(resultado, confirmacion);
    }

    /**
     * Test of cifrarContrasena method, of class UsuarioDAO.
     */
    @Test
    public void pruebaCifrarContrasenaCorrectamente() throws SQLException, IOException {
        String contrasena = "acdc619mljj";
        String contrasenaIncriptada = "49484d2d4d7b4104c96847a1f8a05566526015e2869017e0b45ce413dd3477ce";
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena);
        assertEquals(contrasenaIncriptada, encriptacion);
    }
    
    @Test
    public void pruebaCifrarContrasenaTamañoCorrecto() throws SQLException, IOException{
        String contrasena = "elmejordiadeEsaEpocaFuerevolucionMexicanaFueEnMiL9991231QQQ@@@@@@@@@@@@@";
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena);
        boolean confirmacion = encriptacion.length() == 64;
        assertEquals(true,confirmacion);
    }

    @Test
    public void pruebaSacarDatosCorrectosDeUnUsuario() throws SQLException, IOException {
        String nombreUsuario = "Leonardo";
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Leonardo");
        usuario.setTipo("ASE");
        Usuario usuarioFinal = usuarioDAO.sacarDatosUsuario(nombreUsuario);
        assertEquals(true,usuario.equal(usuarioFinal));
    }
    
    @Test
    public void pruebaSacarDatosIncorrectosDeUnUsuario() throws SQLException, IOException{
        String nombreUsuario = "Roberto";
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Roberto");
        usuario.setTipo("ASE");
        Usuario usuarioFinal = usuarioDAO.sacarDatosUsuario(nombreUsuario);
        assertEquals(false,usuario.equal(usuarioFinal));
    }
    
}
