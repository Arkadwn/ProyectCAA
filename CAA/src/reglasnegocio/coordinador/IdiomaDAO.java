package reglasnegocio.coordinador;

import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reglasnegocio.entidades.ExperienciaEducativa;
import reglasnegocio.entidades.Idioma;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public class IdiomaDAO implements IIdiomaDAO{

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;
    
    public List<Idioma> mostrarIdiomasActuales() throws SQLException, IOException{
        List<Idioma> listaIdiomas = new ArrayList<>();
        Connection conexionBDD;
        Idioma idioma;
        try{
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select idIdioma, nombre from idioma");
            resultadoSQL = sentenciaSQL.executeQuery();
            
            while(resultadoSQL.next()){
                idioma = new Idioma();
                idioma.setIdIdioma(resultadoSQL.getString("idIdioma"));
                idioma.setNombreIdioma(resultadoSQL.getString("nombre"));
                listaIdiomas.add(idioma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al mostrar los idiomas actuales; Error SQLException: ", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al mostrar los idiomas actuales; Error con el archivo de datos BDD", ex);
        }
        return listaIdiomas;
    }
    
}