package reglasnegocio.entidades;

import java.util.Objects;

/**
 * Contiene las caracteristicas de un instrucctor del CAA, donde alla son
 * conocidos como asesores.
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
        final Asesor other = (Asesor) obj;
        if (!Objects.equals(this.numeroPersonal, other.numeroPersonal)) {
            return false;
        }
        return true;
    }
    
    
}
