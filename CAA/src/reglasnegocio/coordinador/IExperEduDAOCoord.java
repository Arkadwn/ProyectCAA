package reglasnegocio.coordinador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.ExperienciaEducativa;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public interface IExperEduDAOCoord {
    public List<ExperienciaEducativa> mostrarEEPorIdioma(String idIdioma)throws SQLException, IOException;
    public List<String> obtenerEEmismoIdioma(String idEE)throws SQLException, IOException;
    public ExperienciaEducativa retornarEEPorIdEE(String idEE) throws SQLException, IOException;
}
