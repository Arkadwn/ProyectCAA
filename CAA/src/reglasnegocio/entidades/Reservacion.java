package reglasnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Leonardo
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
