package reglasnegocio.coordinador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.ExperienciaEducativa;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public interface IExperEduDAO {
    public List<ExperienciaEducativa> mostrarEEPorIdioma(String idIdioma)throws SQLException, IOException;
}
