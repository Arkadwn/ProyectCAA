package reglasnegocio.coordinador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.Idioma;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public interface IIdiomaDAOCoord {
    
    public List<Idioma> mostrarIdiomasActuales()throws SQLException, IOException;
}
