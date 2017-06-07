package reglasnegocio.entidadesDAO;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.entidades.Asesor;

/**
 *
 * @author Leonardo
 */
public class AsesorDAOTest {
    
    public AsesorDAOTest() {
    }
    
    /**
     * Test of sacarDatosAsesor method, of class AsesorDAO.
     */
    @Test
    public void pruebaSacarDatosAsesorCorrectos() throws Exception {
        String nombreUsuario = "Leonardo";
        AsesorDAO asesorDAO = new AsesorDAO();
        Asesor asesor = new Asesor();
        asesor.setNumeroPersonal("1443");
        Asesor result = asesorDAO.sacarDatosAsesor(nombreUsuario);
        assertEquals(true, asesor.equals(result));
    }
    
    @Test
    public void pruebaSacarDatosAsesorInCorrectos() throws SQLException, IOException{
        String nombreUsuario = "Roberto";
        AsesorDAO asesorDAO = new AsesorDAO();
        Asesor asesor = new Asesor();
        asesor.setNumeroPersonal("1443");
        Asesor result = asesorDAO.sacarDatosAsesor(nombreUsuario);
        assertEquals(false, asesor.equals(result));
    }
    
}
