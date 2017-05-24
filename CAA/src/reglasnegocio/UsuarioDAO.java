package reglasnegocio;

import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import static reglasnegocio.utilerias.UtileriasConexionBDD.obtenerDatosBDD;
import static reglasnegocio.utilerias.UtileriasEncriptado.descifra;

/**
 * Establece los metodos con los cuales se ingresa a la capa de conexion a la
 * capa de conexion a la base de datos. Al igual unos metodos de apollo para
 * la verificacion de datos.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    private Connection accesoBDD;
    private DatosConexionBDD datosBDD;
    private String contrasenaBDD;
    
    /**
     * Comprueba si los datos ingresados por el usuario son correctos con
     * respecto a su identidad.
     * 
     * @param usuario nombre que identifica al usuario
     * @param contrasena contraseña del usuario
     * @return regresa la confirmacion de la identidad del usuario
     */
    @Override
    public boolean autentificarUsuario(String usuario, String contrasena) {
        boolean confirmacion = false;
        String contrasenaSha2 = "";
        
        
        try {
            accesoBDD = new Conexion().getConexion("127.0.0.1","usercaa","arkadwn1");
        } catch (SQLException ex) {
            
        }
        
        contrasenaSha2 = cifrarContrasena(contrasena);
        
        try{
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT contrasena from usuario where nombreUsuario = ?");
            sentencia.setString(1, usuario);
            
            ResultSet tabla = sentencia.executeQuery();
            
            if(tabla.next()){
                if(tabla.getString(1).equals(contrasenaSha2)){
                    confirmacion = true;
                }
            }
        }catch(SQLException e){
            
        }finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                
            }
        }
        
        return confirmacion;
    }
    
    /**
     * Codifica la contraseña que ha sido ingresada por el usuario.
     * 
     * @param contrasena contrasena del usuario.
     * @return la contraseña codificada.
     */
    @Override
    public String cifrarContrasena(String contrasena) {
        String contrasenaSha2 = "";
        
        try {
            accesoBDD = new Conexion().getConexion("localhost", "root", "acdc");
        } catch (SQLException ex) {
            
        }
        
        try{
            
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT sha2(?,256)");
            sentencia.setString(1, contrasena);
            
            ResultSet tabla = sentencia.executeQuery();
            
            if(tabla.next()){
                contrasenaSha2 = tabla.getString(1);
            }
        } catch (SQLException e) {
            
        }finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                
            }
        }
        
        return contrasenaSha2;
    }
    
    /**
     * Regresa los datos del usuario para definir sus privilegios.
     * 
     * @param nombreUsuario nombre del usuario.
     * @return datos del usuario
     */
    @Override
    public Usuario sacarDatosUsuario(String nombreUsuario) throws NullPointerException{
        Usuario usuario = null;
        
        try {
            accesoBDD = new Conexion().getConexion("localhost", "root", "acdc");
        } catch (SQLException ex) {
            
        }
        
        try{
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT idUsuario, tipo from Usuario where nombreUsuario = ?");
            sentencia.setString(1, nombreUsuario);
            ResultSet tabla= sentencia.executeQuery();
            
            if(tabla.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(tabla.getString(1));
                usuario.setTipo(tabla.getString(2));
            }
            
        } catch (SQLException ex) {
            
        }finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                
            }
        }
        
        if(usuario == null){
            throw new NullPointerException();
        }
        
        return usuario;
    }
    
}
