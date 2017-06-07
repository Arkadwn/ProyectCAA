package reglasnegocio.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ActividadProgramadaTest {
    
    public ActividadProgramadaTest() {
    }

    /**
     * Test of sumarDiasFecha method, of class ActividadProgramada.
     */
    @Test
    public void pruebaIngrementoCorrecto() {
        int dias = 3;
        Date expResult = new Date();
        Date fecha = ActividadProgramada.sumarDiasFecha(expResult, dias);
        
        
        Date result = ActividadProgramada.sumarDiasFecha(expResult, dias);
        assertEquals(true, fecha.equals(result));
    }
    
    @Test
    public void pruebaFechaActualCorrecta(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        String actual;
        String comparar;
        actual = ActividadProgramada.sacarFechaActual();
        
        comparar = formatoFecha.format(new Date());
        
        actual.equals(comparar);
    }

    
    
}
