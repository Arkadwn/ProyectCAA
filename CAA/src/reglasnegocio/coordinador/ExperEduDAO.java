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
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 *
 * @author Adrian Bustamante Zarate
 */
public class ExperEduDAO implements IExperEduDAO{

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;

    public List<ExperienciaEducativa> mostrarEEPorIdioma(String idIdioma) throws SQLException, IOException{
        List<ExperienciaEducativa> listaEE = new ArrayList<>();
        Connection conexionBDD;
        ExperienciaEducativa EE;
        try{
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select * from EE where idIdoma = ?");
            sentenciaSQL.setString(1, idIdioma);
            resultadoSQL = sentenciaSQL.executeQuery();
            
            while(resultadoSQL.next()){
                EE = new ExperienciaEducativa();
                EE.setCreditos(resultadoSQL.getString("creditos"));
                EE.setIdExperEdu(resultadoSQL.getString("idEE"));
                EE.setIdioma(idIdioma);
                EE.setNombreEE(resultadoSQL.getString("nombre"));
                listaEE.add(EE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al mostrar EEs por idioma; Error SQLException: ", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al mostrar EEs por idioma; Error con el archivo de datos BDD", ex);
        }
        return listaEE;
    }
    
}
