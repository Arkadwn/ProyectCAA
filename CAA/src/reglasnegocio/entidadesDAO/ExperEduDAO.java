package reglasnegocio.entidadesDAO;

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
import reglasnegocio.asesor.IExperienciaEducativaDAOAsesor;
import reglasnegocio.entidades.ExperienciaEducativa;
import reglasnegocio.utilerias.UtileriasConexionBDD;
import reglasnegocio.coordinador.IExperEduDAOCoord;

/**
 * Implementa todos los metodos que son definidos en la interfaz que implementa,
 * declara los metodos que hacen diversos tipos de busquedas, selección de las 
 * EE; en coordinación con la capa de conexionbdd para su uso en capa superior 
 * o de su mismo nivel.
 * 
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class ExperEduDAO implements IExperEduDAOCoord, IExperienciaEducativaDAOAsesor {

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;
    private Connection conexionBDD;

    /**
     * Retorna una lista de EE que tienen en comun un Idioma respecto a su
     * idIdioma
     *
     * @param idIdioma Identificador unico de un idioma
     * @return Lista de EE resultado de la busqueda de EE que tienen en comun un
     * mismo idioma
     * @throws SQLException
     * @throws IOException
     */
    public List<ExperienciaEducativa> mostrarEEPorIdioma(String idIdioma) throws SQLException, IOException {
        List<ExperienciaEducativa> listaEE = new ArrayList<>();
        ExperienciaEducativa EE;
        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select * from EE where idIdioma = ?");
            sentenciaSQL.setString(1, idIdioma);
            resultadoSQL = sentenciaSQL.executeQuery();

            while (resultadoSQL.next()) {
                EE = new ExperienciaEducativa();
                EE.setCreditos(resultadoSQL.getString("creditos"));
                EE.setIdExperEdu(resultadoSQL.getString("idEE"));
                EE.setIdioma(idIdioma);
                EE.setNombreEE(resultadoSQL.getString("nombre"));
                listaEE.add(EE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al mostrar EEs por idioma; Error SQL. ", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al mostrar EEs por idioma; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexción a la BDD al mostrar EEs por idioma", ex);
            }
        }
        return listaEE;
    }

    /**
     * Regresa todas las EE que tengan en común el mismo idioma respecto al
     * identificador de una de estas.
     *
     * @param idEE Identificador unico de una EE
     * @return Lista Strings en las que se concatenan sus id's y sus nombres
     * @throws SQLException
     * @throws IOException
     */
    public List<String> obtenerEEmismoIdioma(String idEE) throws SQLException, IOException {
        List<String> EEs = new ArrayList<>();

        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select idEE, nombre from "
                    + "ee where idIdioma = (select idIdioma from ee where idEE = ?)");
            sentenciaSQL.setString(1, idEE);
            resultadoSQL = sentenciaSQL.executeQuery();

            while (resultadoSQL.next()) {
                EEs.add(resultadoSQL.getString("idEE") + "-" + resultadoSQL.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al mostrar EEs en el mismo idioma; Error SQL ", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al mostrar EEs en el mismo idioma; Error con el archivo de datos BDD.", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD mostrar EEs en el mismo idioma", ex);
            }
        }
        return EEs;
    }

    /**
     * Regresa en un objeto de tipo ExperienciaEducativa todos los datos de la
     * busqueda en la BDD por el idEE de esta misma
     *
     * @param idEE Identificador unico de las EE
     * @return ExperienciaEducativa con la información necesaria segun el idEE
     * enviado
     * @throws SQLException
     * @throws IOException
     */
    public ExperienciaEducativa retornarEEPorIdEE(String idEE) throws SQLException, IOException {
        ExperienciaEducativa EERetornada = new ExperienciaEducativa();

        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select * from ee where idEE = ?");
            sentenciaSQL.setString(1, idEE);
            resultadoSQL = sentenciaSQL.executeQuery();

            while (resultadoSQL.next()) {
                EERetornada.setCreditos(resultadoSQL.getString("creditos"));
                EERetornada.setIdExperEdu(idEE);
                EERetornada.setIdioma(resultadoSQL.getString("idIdioma"));
                EERetornada.setNombreEE(resultadoSQL.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al retornar EE por id; Error SQL ", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al retornar EE por id; Error con el archivo de datos BDD.", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al mostrar EE por id", ex);
            }
        }

        return EERetornada;
    }
}
