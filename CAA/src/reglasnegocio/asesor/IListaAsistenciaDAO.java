package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import reglasnegocio.entidades.ListaAsistencia;

/**
 *
 * @author Leonardo
 */
public interface IListaAsistenciaDAO {
    public boolean guardarListaAsistencia(ListaAsistencia asistencia)throws SQLException, IOException;
    public ListaAsistencia sacarListaAsistencia(String idActividad) throws SQLException, IOException;
    public boolean verificarAntecedentes(String idActividad) throws SQLException, IOException;
}
