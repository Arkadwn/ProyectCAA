package reglasnegocio.entidadesDAO;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.entidades.Idioma;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class IdiomaDAOIT {
    
    public IdiomaDAOIT() {
    }
    
    @Test
    public void testMostrarIdiomasActuales() throws Exception {
        System.out.println("mostrar todos los Idiomas actuales");
        IdiomaDAO instance = new IdiomaDAO();
        List<Idioma> result = instance.mostrarIdiomasActuales();
        assertEquals(true, !result.isEmpty());
        
        //fail("The test case is a prototype.");
    }
    
}
