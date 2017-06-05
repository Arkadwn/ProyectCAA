package reglasnegocio.entidades;

/**
 *
 * @author Miguel Leonardo Jiménez Jiménez
 * @author Adrian Bustamante Zarate
 */
public class Asesor extends Persona{
    private String numeroPersonal;
    private boolean idiomaIngles;
    private boolean idiomaFrances;

    public boolean isIdiomaIngles() {
        return idiomaIngles;
    }

    public void setIdiomaIngles(boolean idiomaIngles) {
        this.idiomaIngles = idiomaIngles;
    }

    public boolean isIdiomaFrances() {
        return idiomaFrances;
    }

    public void setIdiomaFrances(boolean idiomaFrances) {
        this.idiomaFrances = idiomaFrances;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }
    
    
}
