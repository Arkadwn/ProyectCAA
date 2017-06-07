package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.Idioma;

/**
 * Especifica los metodos que un asesor puede realizar con respecto a la clase
 * IdiomaDAO.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IIdiomaDAOAsesor {
    public List<Idioma> mostrarIdiomasActuales()throws SQLException, IOException;
}
