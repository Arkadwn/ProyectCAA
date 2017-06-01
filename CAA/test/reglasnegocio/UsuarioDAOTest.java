package reglasnegocio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import reglasnegocio.utilerias.UtileriasConexionBDD;

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
    public void pruebaUsuarioYContraseñaIncorecctos() {
        String usuario = "Leonardo";
        String contrasena = "acdc619mljj";
        boolean resultado = true;
        boolean confirmacion = usuarioDAO.autentificarUsuario(usuario, contrasena);
        assertEquals(resultado, confirmacion);
    }
    
    /**
     * Prueba de un usuario correcto y una contraseña incorrecta
     */
    @Test
    public void pruebaUsuarioCorrectoYContrasenaIncorrecto() {
        String usuario = "Mauricio";
        String contrasena = "acdc619mljj";
        boolean resultado = false;
        boolean confirmacion = usuarioDAO.autentificarUsuario(usuario, contrasena);
        assertEquals(resultado, confirmacion);
    }
    
    /**
     * Prueba de seguridad contra inyeccion de codigo
     */
    @Test
    public void pruebaContraInyeccionDeCodigo(){
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
    public void pruebaCifrarContrasenaCorrectamente() {
        String contrasena = "acdc619mljj";
        String contrasenaIncriptada = "49484d2d4d7b4104c96847a1f8a05566526015e2869017e0b45ce413dd3477ce";
        
        try {
            datosBD = UtileriasConexionBDD.obtenerDatosBDD();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena,datosBD);
        assertEquals(contrasenaIncriptada, encriptacion);
    }
    
    @Test
    public void pruebaCifrarContrasenaTamañoCorrecto(){
        String contrasena = "elmejordiadeEsaEpocaFuerevolucionMexicanaFueEnMiL9991231QQQ@@@@@@@@@@@@@";
        
        try {
            datosBD = UtileriasConexionBDD.obtenerDatosBDD();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena,datosBD);
        boolean confirmacion = encriptacion.length() == 64;
        assertEquals(true,confirmacion);
    }

    @Test
    public void pruebaSacarDatosCorrectosDeUnUsuario() {
        String nombreUsuario = "Leonardo";
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("USU1");
        usuario.setTipo("ASE");
        Usuario usuarioFinal = usuarioDAO.sacarDatosUsuario(nombreUsuario);
        assertEquals(true,usuario.equal(usuarioFinal));
    }
    
    @Test
    public void pruebaSacarDatosIncorrectosDeUnUsuario(){
        String nombreUsuario = "Roberto";
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("USU2");
        usuario.setTipo("ASE");
        Usuario usuarioFinal = usuarioDAO.sacarDatosUsuario(nombreUsuario);
        assertEquals(false,usuario.equal(usuarioFinal));
    }
    
}
