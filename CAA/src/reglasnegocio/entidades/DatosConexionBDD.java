package reglasnegocio.entidades;
import java.io.Serializable;

/**
 * Define los datos necesarios para la conexión a la BDD.
 * 
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez Jimenez
 * @version 21/05/2017
 */
public class DatosConexionBDD implements Serializable{
    private String direccionIP;
    private String usuario;
    private byte[] contraseña;

    public String getDireccionIP() {
        return direccionIP;
    }
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public byte[] getContraseña() {
        return contraseña;
    }
    public void setContraseña(byte[] contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
