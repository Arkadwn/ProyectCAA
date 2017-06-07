package reglasnegocio.entidades;

/**
 * Contiene las caracteristicas que le pertenecen a un usuario que pertenece al
 * sistema CAA, para su posterior cargo de permisos.
 * 
 * @author Miguel Leonardo Jiménez Jiménez
 * @author Adrina Bustamante Zarate
 */
public class Usuario {
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
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean equal(Usuario usuario){
        return usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getTipo().equals(tipo);
    }
}
