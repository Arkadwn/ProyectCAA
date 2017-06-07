package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.ActividadProgramada;

/**
 * Especifica los metodos que un asesor puede realizar con respecto a la clase
 * actividadProgramada
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 */
public interface IActividadProgramadaDAO {
    public List<ActividadProgramada> sacarActividadesProgramadas(String numPersonal, String idEE, String lapso) throws SQLException, IOException;
    
}
