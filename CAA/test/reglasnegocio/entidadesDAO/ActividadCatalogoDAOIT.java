package reglasnegocio.entidadesDAO;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.entidades.ActividadCatalogo;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class ActividadCatalogoDAOIT {
    
    public ActividadCatalogoDAOIT() {
    }

    @Test
    public void testGuardarActividadCatal() throws Exception {
        System.out.println("guardarActividadCatal");
        String experEdu = "E1";
        String tipoActividad = "Taller";
        String nombreActividadCat = "Taller de lectura prueba";
        String descripActivi = "Esta actividad es para probar el sistema";
        ActividadCatalogoDAO instance = new ActividadCatalogoDAO();
        boolean expResult = true;
        boolean result = instance.guardarActividadCatal(experEdu, tipoActividad, nombreActividadCat, descripActivi);
        assertEquals(expResult, result);
        //fail("Fallo el test para guardar una actividad");
    }


    @Test
    public void testBuscarActividades() throws Exception {
        System.out.println("Buscar actividades");
        String criterioBusq = "ee.nombre";
        String busqueda = "Inglés 1";
        ActividadCatalogoDAO instance = new ActividadCatalogoDAO();
        List<ActividadCatalogo> result = instance.buscarActividades(criterioBusq, busqueda);
        assertEquals(true, !result.isEmpty());
        //fail("Fallo el test para buscar actividades");
    }

    @Test
    public void testEditarActividadCatalExitoso() throws Exception {
        System.out.println("editarActividadCatal");
        ActividadCatalogo activiCatalModif = new ActividadCatalogo("E2", "PRUEBA", "Ingles sin acento", "Actividad de prueba para el test");
        activiCatalModif.setIdActividad("5");
        ActividadCatalogoDAO instance = new ActividadCatalogoDAO();
        boolean expResult = true;
        boolean result = instance.editarActividadCatal(activiCatalModif);
        assertEquals(expResult, result);
        //fail("Fallo la prueba de editar una actividad");
    }

    @Test
    public void testMostrarDetallesActiv() throws Exception {
        System.out.println("mostrarDetallesActiv");
        String idActiviCatal = "5";
        ActividadCatalogoDAO instance = new ActividadCatalogoDAO();
        ActividadCatalogo resultadoMetodo = instance.mostrarDetallesActiv(idActiviCatal);
        
        assertEquals(true, resultadoMetodo.getIdActividad().equalsIgnoreCase(idActiviCatal));
        //fail("Fallo prueba para mostrar los detalles de la actividad");
    }

    @Test
    public void testBorrarActiviCatal() throws Exception {
        System.out.println("borrarActiviCatal");
        String idActiviCatal = "6";
        ActividadCatalogoDAO instance = new ActividadCatalogoDAO();
        boolean expResult = true;
        boolean result = instance.borrarActiviCatal(idActiviCatal);
        assertEquals(expResult, result);
        //fail("Fallo prueba de borrado de actividad");
    }
    
}
