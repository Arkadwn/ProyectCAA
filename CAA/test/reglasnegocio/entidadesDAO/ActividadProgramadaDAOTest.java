package reglasnegocio.entidadesDAO;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.entidades.ActividadProgramada;

/**
 *
 * @author Leonardo
 */
public class ActividadProgramadaDAOTest {
    
    public ActividadProgramadaDAOTest() {
    }
    /**
     * Test of sacarActividadesProgramadas method, of class ActividadProgramadaDAO.
     */
    @Test
    public void pruebaBuscarUnaDelDia() throws Exception {
        String numPersonal = "1443";
        String idEE = "E1";
        String lapso = "HOY";
        boolean confirmacion = false;
        ActividadProgramadaDAO dao = new ActividadProgramadaDAO();
        ActividadProgramada actividad = new ActividadProgramada();
        actividad.setIdActividadProgramada("ACP05");
        List<ActividadProgramada> result = dao.sacarActividadesProgramadas(numPersonal, idEE, lapso);
        
        for(ActividadProgramada act :result){
            if(act.equals(actividad)){
                confirmacion = true;
            }
        }
        
        
        assertEquals(true, confirmacion);
    }
    @Test
    public void pruebaBuenFiltrado() throws Exception {
        String numPersonal = "1443";
        String idEE = "E1";
        String lapso = "HOY";
        boolean confirmacion = false;
        ActividadProgramadaDAO dao = new ActividadProgramadaDAO();
        ActividadProgramada actividad = new ActividadProgramada();
        actividad.setIdActividadProgramada("ACP05");
        List<ActividadProgramada> result = dao.sacarActividadesProgramadas(numPersonal, idEE, lapso);
        
        for(ActividadProgramada act :result){
            if(act.equals(actividad)){
                confirmacion = true;
            }
        }
        
        
        assertEquals(true, confirmacion);
    }
    
    @Test
    public void pruebaFiltrarPasadas() throws Exception {
        String numPersonal = "1443";
        String idEE = "E1";
        String lapso = "HOY";
        boolean confirmacion = false;
        ActividadProgramadaDAO dao = new ActividadProgramadaDAO();
        ActividadProgramada actividad = new ActividadProgramada();
        actividad.setIdActividadProgramada("ACP01");
        List<ActividadProgramada> result = dao.sacarActividadesProgramadas(numPersonal, idEE, lapso);
        
        for(ActividadProgramada act :result){
            if(act.equals(actividad)){
                confirmacion = true;
            }
        }
        
        
        assertEquals(false, confirmacion);
    }
    
}
