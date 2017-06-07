package reglasnegocio.entidadesDAO;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.entidades.ExperienciaEducativa;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class ExperEduDAOIT {
    
    public ExperEduDAOIT() {
    }

    @Test
    public void testMostrarEEPorIdioma() throws Exception {
        System.out.println("mostrar EEs en el mismo Idioma");
        String idIdioma = "L2";
        ExperEduDAO instance = new ExperEduDAO();
        List<ExperienciaEducativa> result = instance.mostrarEEPorIdioma(idIdioma);
        assertEquals(true, !result.isEmpty());
        
        //fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerEEmismoIdioma() throws Exception {
        System.out.println("obtener EEs con el mismo Idioma");
        String idEE = "E3";
        ExperEduDAO instance = new ExperEduDAO();
        List<String> result = instance.obtenerEEmismoIdioma(idEE);
        assertEquals(true, result.size()==3);
        
        //fail("The test case is a prototype.");
    }


    @Test
    public void testRetornarEEPorIdEE() throws Exception {
        System.out.println("retornar EE por su IdEE");
        String idEE = "E2";
        ExperEduDAO instance = new ExperEduDAO();
        ExperienciaEducativa result = instance.retornarEEPorIdEE(idEE);
        assertEquals(true, result.getIdExperEdu().equals(idEE));
        
        //fail("The test case is a prototype.");
    }
    
}
