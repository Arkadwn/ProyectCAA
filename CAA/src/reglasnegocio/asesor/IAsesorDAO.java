package reglasnegocio.asesor;

import java.sql.SQLException;
import reglasnegocio.entidades.Asesor;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IAsesorDAO {
    public Asesor sacarDatosAsesor(String nombreUsuario)throws SQLException;
}
