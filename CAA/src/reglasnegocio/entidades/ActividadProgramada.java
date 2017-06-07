package reglasnegocio.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Contiene todos los atributos que se le dan a una actividad cuando fue
 * asignada a una fecha en especifico, un asesor que la imparta, asi como los
 * alumno que se puntaron dentro de ella.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class ActividadProgramada {
    private String HoraInicio;
    private String HoraFin;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRealizar;
    private String idActividadProgramada;
    private boolean estado;
    private ActividadCatalogo actividad;
    private int cupo;
    private Salon salon;
    private Asesor asesor;
    private List<Reservacion> reservaciones;

    public String getFechaRealizar() {
        return fechaRealizar;
    }

    public void setFechaRealizar(String fechaRealizar) {
        this.fechaRealizar = fechaRealizar;
    }

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
    
    /**
     * Realiza un filtrado de actividades de un asesor segun la fcha y hora en
     * que seran realizadas, con el fin de no mostrar las actividades que ya
     * han pasado o fueron suspendidas.
     * 
     * @param actividades List de ActividadProgramada asignadas a un asesor
     * @param lapso filtro de acuerdo al rango de tiempo que desea.
     * @return List de ActividadProgramada las cuales cumplen con los
     * requerimientos establecidos.
     */
    public static List<ActividadProgramada> filtrarActividades(List<ActividadProgramada> actividades, String lapso){
        List<ActividadProgramada> actividadesFiltradas = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        LocalTime horaActividad = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaActual = null;
        Date fechaActividad = null;
        
        try {
            fechaActual = formatoFecha.parse(sacarFechaActual());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
        LocalTime horaActual = LocalTime.now();
        
        for(ActividadProgramada actividad: actividades){
            
            try {
                fechaActividad = formatoFecha.parse(actividad.getFechaRealizar());
                horaActividad = LocalTime.parse(actividad.getHoraInicio());
            } catch (ParseException | DateTimeParseException ex) {
                System.out.println(ex.getMessage());
            }
            
            if(fechaActividad.equals(fechaActual)){
                if(horaActividad.isAfter(horaActual) && actividad.estado){
                    actividadesFiltradas.add(actividad);
                }
            }else if(fechaActividad.after(fechaActual) && actividad.estado && lapso.equals("Semana") && fechaActividad.before(sumarDiasFecha(fechaActual, 6 - (calendar.get(Calendar.DAY_OF_WEEK))))){
                    actividadesFiltradas.add(actividad);
            }
            
        }
        
        return actividadesFiltradas;
    }
    
    /**
     * Calcula la fecha actual y la guarda en una cadena, con el formato
     * yyyy-MM-dd.
     * 
     * @return cadena que contiene la fecha actual
     */
    public static String sacarFechaActual(){
        String fecha;
        Calendar calendar = Calendar.getInstance();
        
        fecha = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) +"-"+calendar.get(Calendar.DAY_OF_MONTH);
        
        return fecha;
    }
    
    /**
     * Realiza una suma de dias un tipo Date que contiene una fecha x.
     * 
     * @param fecha Date al cual se le aumentar un sierto numero de dias.
     * @param dias dias que seran agregados a la fecha.
     * @return regresa el Date ya con los dias agregados.
     */
    public static Date sumarDiasFecha(Date fecha, int dias){
        
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE,dias);
        
        return calendario.getTime();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadProgramada other = (ActividadProgramada) obj;
        if (!Objects.equals(this.idActividadProgramada, other.idActividadProgramada)) {
            return false;
        }
        return true;
    }
    
    
}
