package reglasnegocio.entidades;

/**
 * Contiene las caracteristicas de un salon de clases, los cuales son apartados
 * para la realizacion de activadesProgramadas.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian bustamante Zarate
 */
public class Salon {
    private String nombreSalon;
    private Integer cupo;
    private String idSalon;

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }
    
}
