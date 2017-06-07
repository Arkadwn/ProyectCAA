package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.Idioma;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IIdiomaDAOAsesor {
    public List<Idioma> mostrarIdiomasActuales()throws SQLException, IOException;
}
