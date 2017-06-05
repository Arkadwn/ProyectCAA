package reglasnegocio.coordinador;

import reglasnegocio.entidades.ActividadCatalogo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public interface IActividadCatalogoDAO {
    public boolean guardarActividadCatal(String experEdu, String tipoActividad, String nombreActividadCat, String descripActivi) 
            throws SQLException, IOException;
    public List<ActividadCatalogo> buscarActividades(String criterioBusq, String busqueda) throws SQLException, IOException;
    public boolean editarActividadCatal(ActividadCatalogo activiCatalModif)throws SQLException, IOException;
    public ActividadCatalogo mostrarDetallesActiv(String idActiviCatal) throws SQLException, IOException;
    public boolean borrarActiviCatal(String idActiviCatal) throws SQLException, IOException;
}
