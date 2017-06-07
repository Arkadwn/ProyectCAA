package reglasnegocio.asesor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import reglasnegocio.entidades.ExperienciaEducativa;

/**
 * Especifica los metodos que un asesor puede realizar con respecto a la clase 
 * ExperEduDAO
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public interface IExperienciaEducativaDAOAsesor {
    public List<ExperienciaEducativa> mostrarEEPorIdioma(String idIdioma)throws SQLException, IOException;
}
