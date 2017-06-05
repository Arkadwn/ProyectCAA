package reglasnegocio.asesor;

import java.util.List;
import reglasnegocio.entidades.ActividadProgramada;

/**
 *
 * @author Leonardo
 */
public interface IActividadProgramadaDAO {
    public List<ActividadProgramada> sacarActividadesProgramadas(String numPersonal, String idEE, String lapso);
}
