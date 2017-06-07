package reglasnegocio.coordinador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.Idioma;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public interface IIdiomaDAOCoord {
    
    public List<Idioma> mostrarIdiomasActuales()throws SQLException, IOException;
}
