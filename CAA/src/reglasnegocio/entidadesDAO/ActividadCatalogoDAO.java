package reglasnegocio.entidadesDAO;

import reglasnegocio.entidades.ActividadCatalogo;
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
import reglasnegocio.utilerias.UtileriasConexionBDD;
import reglasnegocio.coordinador.IActividadCatalogoDAOCoord;

/**
 * Implementa todos los metodos que son definidos en la interfaz que implementa,
 * declara los metodos que controlan y manipulan la creación, la edición, la 
 * eliminación, la busqueda y la selección de las actividades, en coordinación 
 * con la capa de conexionbdd para su uso en capa superior o de su mismo nivel.
 * 
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class ActividadCatalogoDAO implements IActividadCatalogoDAOCoord {

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;
    private Connection conexionBDD;

    /**
     * Guarda una actividad en la BDD, segun sean los parametros enviados
     * 
     * @param experEdu identificador de la EE a la que pertence
     * @param tipoActividad Establece el tipo de Actividad
     * @param nombreActividadCat Nombre de la actividad a guardar
     * @param descripActivi Breve descripción de la actividad a guardar
     * @return true si se guardo correctamente la actividad
     * @throws SQLException
     * @throws IOException
     */
    public boolean guardarActividadCatal(String experEdu, String tipoActividad, String nombreActividadCat, String descripActivi)
            throws SQLException, IOException {
        boolean seGuardo = true;

        try {

            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("insert into ActividadCatalogo values(?, ?, ?, ?, ?)");
            sentenciaSQL.setString(1, null);
            sentenciaSQL.setString(2, nombreActividadCat);
            sentenciaSQL.setString(3, experEdu);
            sentenciaSQL.setString(4, tipoActividad);
            sentenciaSQL.setString(5, descripActivi);
            sentenciaSQL.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seGuardo = false;
            throw new SQLException("Error al guardar una actividad; Error SQL", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seGuardo = false;
            throw new IOException("Error al guardar una actividad; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al guardar una actividad", ex);
            }
        }

        return seGuardo;
    }

    /**
     * Realiza una busqueda de todas las actividades concordantes con un 
     * criterio de busqueda que es mandado como parametro y la busqueda en si.
     * El resultado lo almacena en una lista de ActividadCatalogo.
     * 
     * @param criterioBusq Criterio de busqueda para la consulta
     * @param busqueda Lo que sera comparado con el criterio de busqueda
     * @return Lista de Actividades cada una corresponde a un resultado de 
     * la consulta
     * @throws SQLException
     * @throws IOException
     */
    public List<ActividadCatalogo> buscarActividades(String criterioBusq, String busqueda) throws SQLException, IOException {
        List<ActividadCatalogo> listaActividades = new ArrayList();
        ActividadCatalogo actividad;

        try {

            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select actividadcatalogo.idactividad, "
                    + "actividadcatalogo.nombreactividad from actividadcatalogo, ee where "
                    + criterioBusq + " = ? and ee.idee = actividadcatalogo.idee;");
            sentenciaSQL.setString(1, busqueda);
            resultadoSQL = sentenciaSQL.executeQuery();

            while (resultadoSQL.next()) {
                actividad = new ActividadCatalogo();
                actividad.setIdActividad(resultadoSQL.getString("idActividad"));
                actividad.setNombre(resultadoSQL.getString("nombreActividad"));
                listaActividades.add(actividad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al realizar una busqueda de actividades; Error SQL", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al realizar una busqueda de actividades; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al realizar una busqueda de una actividad", ex);
            }
        }
        return listaActividades;
    }

    /**
     * Realiza una actualización a los datos de una actividad ya guardada en la 
     * BDD. Recibé un objeto de tipo ActividadCatalogo, extrae la información y
     * realiza la edición de la actividad en la BDD.
     * 
     * @param activiCatalModif objeto ActividadCatalogo que contiene toda la 
     * información nueva a modificar para la Actividad ya almacenada
     * @return true si la edición se realizo con exito, en caso contrario
     * retorna un true
     * @throws SQLException
     * @throws IOException
     */
    public boolean editarActividadCatal(ActividadCatalogo activiCatalModif) throws SQLException, IOException {
        boolean seEdito = true;

        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("update ActividadCatalogo set nombreActividad = ?, idEE = ?, tipo = ?, descripcion = ? where idActividad = ?");
            sentenciaSQL.setString(1, activiCatalModif.getNombre());
            sentenciaSQL.setString(2, activiCatalModif.getExperEdu());
            sentenciaSQL.setString(3, activiCatalModif.getTipoActividad());
            sentenciaSQL.setString(4, activiCatalModif.getDescripcion());
            sentenciaSQL.setInt(5, Integer.parseInt(activiCatalModif.getIdActividad()));
            sentenciaSQL.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seEdito = false;
            throw new SQLException("Error al editar una actividad; Error SQL", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seEdito = false;
            throw new IOException("Error al editar una actividad; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al editar una actividad", ex);
            }
        }

        return seEdito;
    }

    /**
     * Retorna un objeto del tipo ActividadCatalogoresultado de una busqueda
     * en la BDD de una actividad por su identificador. El objeto contiene toda
     * la información de la actividad requeridad.
     * 
     * @param idActiviCatal identificador unico de la actividad solicitada
     * @return Objeto del tipo ActividadCatalogo que contiene toda la 
     * información de la actividad requeridad.
     * @throws SQLException
     * @throws IOException
     */
    public ActividadCatalogo mostrarDetallesActiv(String idActiviCatal) throws SQLException, IOException {
        ActividadCatalogo actividad = new ActividadCatalogo();

        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("select * from ActividadCatalogo where idActividad = ?");
            sentenciaSQL.setString(1, idActiviCatal);
            resultadoSQL = sentenciaSQL.executeQuery();

            while (resultadoSQL.next()) {
                actividad.setIdActividad(idActiviCatal);
                actividad.setNombre(resultadoSQL.getString("nombreActividad"));
                actividad.setExperEdu(resultadoSQL.getString("idEE"));
                actividad.setTipoActividad(resultadoSQL.getString("tipo"));
                actividad.setDescripcion(resultadoSQL.getString("descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error al mostrar detalles de una actividad; Error SQL", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error al mostrar detalles de una actividad; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al mostrar detalles de una actividad", ex);
            }
        }

        return actividad;
    }

    /**
     * Realiza la eliminación de una actividad almacenada en la BDD segun su 
     * identificador.
     * 
     * @param idActiviCatal identificador unico de la actividad a borrar
     * @return true si la eliminación fue exitosa y retorna falso si no fue así
     * @throws SQLException
     * @throws IOException
     */
    public boolean borrarActiviCatal(String idActiviCatal) throws SQLException, IOException {
        boolean seBorro = true;

        try {
            conexionBDD = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexionBDD.prepareStatement("delete from ActividadCatalogo where idActividad = ?");
            sentenciaSQL.setString(1, idActiviCatal);
            sentenciaSQL.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seBorro = false;
            throw new SQLException("Error al borrar una actividad; Error SQL", ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
            seBorro = false;
            throw new IOException("Error al borrar una actividad; Error con el archivo de datos BDD", ex);
        } finally {
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al borrar una Actividad de catalogo", ex);
            }
        }

        return seBorro;
    }
}
