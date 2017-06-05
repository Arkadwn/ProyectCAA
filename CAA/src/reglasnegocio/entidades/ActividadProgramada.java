package reglasnegocio.entidades;

import java.util.List;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class ActividadProgramada {
    private String HoraInicio;
    private String HoraFin;
    private String fechaInicio;
    private String fechaFin;
    private String idActividadProgramada;
    private boolean estado;
    private ActividadCatalogo actividad;
    private int cupo;
    private Salon salon;
    private Asesor asesor;
    private List<Reservacion> reservaciones;

    public String getHoraInicio() {
        return HoraInicio;
    }

    public ActividadCatalogo getActividad() {
        return actividad;
    }

    public void setActividad(ActividadCatalogo actividad) {
        this.actividad = actividad;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIdActividadProgramada() {
        return idActividadProgramada;
    }

    public void setIdActividadProgramada(String idActividadProgramada) {
        this.idActividadProgramada = idActividadProgramada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }
    
}
