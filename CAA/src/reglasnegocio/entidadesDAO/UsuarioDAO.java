package reglasnegocio.entidadesDAO;

import reglasnegocio.entidades.Usuario;
import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reglasnegocio.usuariogeneral.IUsuarioDAO;
import reglasnegocio.utilerias.UtileriasConexionBDD;

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
    
    /**
     * Comprueba si los datos ingresados por el usuario son correctos con
     * respecto a su identidad.
     * 
     * @param usuario nombre que identifica al usuario
     * @param contrasena contraseña del usuario
     * @return regresa la confirmacion de la identidad del usuario
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    @Override
    public boolean autentificarUsuario(String usuario, String contrasena) throws SQLException, IOException{
        boolean confirmacion = false;
        String contrasenaSha2;
        
        
        contrasenaSha2 = cifrarContrasena(contrasena);
        
        try{
            accesoBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT contrasena from usuario where nombreUsuario = ?");
            sentencia.setString(1, usuario);
            
            ResultSet tabla = sentencia.executeQuery();
            
            if(tabla.next()){
                if(tabla.getString(1).equals(contrasenaSha2)){
                    confirmacion = true;
                }
            }
        }catch(SQLException e){
            
        } catch (IOException | ClassNotFoundException ex) {
            
        }  finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                throw new SQLException("Error la cerrar la conexion a la base de datos",ex);
            }
        }
        
        return confirmacion;
    }
    
    /**
     * Codifica la contraseña que ha sido ingresada por el usuario.
     * 
     * @param contrasena contrasena del usuario.
     * @return la contraseña codificada.
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    @Override
    public String cifrarContrasena(String contrasena) throws SQLException,IOException{
        String contrasenaSha2 = "";
        
        try{
            accesoBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT sha2(?,256)");
            sentencia.setString(1, contrasena);
            
            ResultSet tabla = sentencia.executeQuery();
            
            if(tabla.next()){
                contrasenaSha2 = tabla.getString(1);
            }
        } catch (SQLException ex) {
            throw new SQLException("Ocurrio un error al encriptar la contraseña",ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error al cargar la configuracion de la base de datos",ex);
        }finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                throw new SQLException("Erroe al cerrar la conexion a la base de datos",ex);
            }
        }
        
        return contrasenaSha2;
    }
    
    /**
     * Regresa los datos del usuario para definir sus privilegios.
     * 
     * @param nombreUsuario nombre del usuario.
     * @return datos del usuario
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    @Override
    public Usuario sacarDatosUsuario(String nombreUsuario) throws SQLException,IOException{
        Usuario usuario = null;
        
        try{
            accesoBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            PreparedStatement sentencia = accesoBDD.prepareStatement("SELECT tipo,nombreUsuario from Usuario where nombreUsuario = ?");
            sentencia.setString(1, nombreUsuario);
            
            ResultSet tabla= sentencia.executeQuery();
            
            if(tabla.next()){
                usuario = new Usuario();
                usuario.setNombreUsuario(tabla.getString(2));
                usuario.setTipo(tabla.getString(1));
            }
            
        } catch (SQLException ex) {
            throw new SQLException("Ha ocurrido un error al sacar los datos del asesor",ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error en el archivo que contiene los datos de la BDD",ex);
        }finally{
            try {
                new Conexion().cerrarConexion(accesoBDD);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion a la base de datos",ex);
            }
        }
        
        return usuario;
    }
    
}
