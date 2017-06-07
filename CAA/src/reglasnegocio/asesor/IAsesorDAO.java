package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import reglasnegocio.entidades.Asesor;

/**
 * Especifica los metodos que el asesor puede realizar con respecto a la clase
 * AsesorDAO.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IAsesorDAO {
    public Asesor sacarDatosAsesor(String nombreUsuario)throws SQLException, IOException;
}
