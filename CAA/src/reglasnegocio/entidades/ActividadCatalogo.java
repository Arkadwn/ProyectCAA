package reglasnegocio.entidades;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public class ActividadCatalogo {
    private String experEdu;
    private String tipoActividad;
    private String nombreActividadCat;
    private String descripcion;
    private String idActividad;

    public ActividadCatalogo(String experEdu, String tipoActividad, String nombreActividadCat, String descripcion) {
        this.experEdu = experEdu;
        this.tipoActividad = tipoActividad;
        this.nombreActividadCat = nombreActividadCat;
        this.descripcion = descripcion;
    }

    public ActividadCatalogo() {}

    public String getExperEdu() {
        return experEdu;
    }

    public void setExperEdu(String experEdu) {
        this.experEdu = experEdu;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombre() {
        return nombreActividadCat;
    }

    public void setNombre(String nombreActividadCat) {
        this.nombreActividadCat = nombreActividadCat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }
    
}
