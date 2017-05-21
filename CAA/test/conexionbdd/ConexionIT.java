package conexionbdd;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez 
 */
public class ConexionIT {
    public ConexionIT() {
    }
    
    /**
     * Tests of getConexion method, of class Conexion.
     */
    @Test
    public void testGetConexion() {
        System.out.println("Test de metodo: getConexion");
        String iP = "localhost";
        String usuario = "usercaa";
        String contraseña = "arkadwn1";
        Conexion conexion = new Conexion();
        try{
        Connection result = conexion.getConexion(iP, usuario, contraseña);
        assertEquals(true, !result.isClosed());
        }catch(SQLException sqlE){
            fail("No se pudo establecer la conexión.");
        }
    }
    @Test
        public void testNoGetConexion() {
        System.out.println("Test de metodo: getConexion");
        String iP = "localhost";
        String usuario = "usercaa";
        String contraseña = "arkadwn";
        Conexion conexion = new Conexion();
        try{
        Connection result = conexion.getConexion(iP, usuario, contraseña);
        fail("No se debería establecer conexión.");
        }catch(SQLException sqlE){
            assertEquals("Error al conectar por: "+sqlE.getMessage(),true, true);
        }
    }
    /**
     * Tests of cerrarConexion method, of class Conexion.
     */
    @Test
    public void testCerrarConexion() throws SQLException {
        System.out.println("Test de metodo: cerrarConexion");
        Connection conexion = new Conexion().getConexion("localhost", "usercaa", "arkadwn1");
        Conexion conexionTest = new Conexion();
        try{
        conexionTest.cerrarConexion(conexion);
        }catch(SQLException sqlE){
            fail("No se pudo establecer la conexión.");
        }
        assertEquals(true, conexion.isClosed());
    }
    
}
