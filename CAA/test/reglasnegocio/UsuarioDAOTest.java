package reglasnegocio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class UsuarioDAOTest {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDAOTest() {
        usuarioDAO = new UsuarioDAO();
    }
    

    /**
     * Pruena de un usuario incorrecto y una contraseña incorrecta.
     */
    @Test
    public void pruebaUsuarioYContraseñaIncorecctos() {
        String usuario = "Foraneos";
        String contrasena = "portafolio";
        boolean resultado = false;
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
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena);
        assertEquals(contrasenaIncriptada, encriptacion);
    }
    
    @Test
    public void pruebaCifrarContrasenaTamañoCorrecto(){
        String contrasena = "elmejordiadeEsaEpocaFuerevolucionMexicanaFueEnMiL9991231QQQ@@@@@@@@@@@@@";
        String encriptacion = usuarioDAO.cifrarContrasena(contrasena);
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
