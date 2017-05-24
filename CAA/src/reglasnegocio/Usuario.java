package reglasnegocio;

/**
 *
 * @author Miguel Leonardo Jiménez Jiménez
 * @author Adrina Bustamante Zarate
 */
public class Usuario {
    private String idUsuario;
    private String tipo;
    private String contrasena;
    private String nombreUsuario;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean equal(Usuario usuario){
        return usuario.getIdUsuario().equals(idUsuario) && usuario.getTipo().equals(tipo);
    }
}
