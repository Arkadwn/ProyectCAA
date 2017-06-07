package reglasnegocio.entidades;

import java.util.List;

/**
 * Es la agrupacion de UsuarioAutonomos que reservaron un lugar en alguna 
 * ActividadProgramada.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class ListaAsistencia {
    private ActividadProgramada actividad;
    private String fechaModificacion;
    private List<UsuarioAutonomo> listaAsistencia;
    private String idListaAsistencia;
    private Boolean[] asistencia;

    public Boolean[] getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean[] asistencia) {
        this.asistencia = asistencia;
    }

    public ActividadProgramada getActividad() {
        return actividad;
    }

    public void setActividad(ActividadProgramada actividad) {
        this.actividad = actividad;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<UsuarioAutonomo> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<UsuarioAutonomo> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public String getIdListaAsistencia() {
        return idListaAsistencia;
    }

    public void setIdListaAsistencia(String idListaAsistencia) {
        this.idListaAsistencia = idListaAsistencia;
    }
}
