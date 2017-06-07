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
 *
 * @author Adrian Bustamante Zarate
 */
public class ActividadCatalogoDAO implements IActividadCatalogoDAOCoord {

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;
    private Connection conexionBDD;

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
