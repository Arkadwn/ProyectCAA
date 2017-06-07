package reglasnegocio.entidades;

import java.util.Date;

/**
 * Contiene los datos que se manejan para registrar el apartado de un lugar en
 * alguna ActividadProgramada por un UsuarioAutonomo.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class Reservacion {
    private Date fechaCreacion;
    private String idReservacion;
    private ActividadProgramada actividadProgramada;
    private UsuarioAutonomo usuarioautonomo;

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public ActividadProgramada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(ActividadProgramada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }

    public UsuarioAutonomo getUsuarioautonomo() {
        return usuarioautonomo;
    }

    public void setUsuarioautonomo(UsuarioAutonomo usuarioautonomo) {
        this.usuarioautonomo = usuarioautonomo;
    }
}
