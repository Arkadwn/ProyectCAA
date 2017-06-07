package reglasnegocio.entidades;

/**
 * Contiene todas las caracteristicas que definen o son necesarias para algun
 * estudiante poder tomar un curso dentro del CAA.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class UsuarioAutonomo extends Persona{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
