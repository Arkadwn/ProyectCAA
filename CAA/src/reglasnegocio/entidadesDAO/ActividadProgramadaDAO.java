package reglasnegocio.entidadesDAO;

import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reglasnegocio.asesor.IActividadProgramadaDAO;
import reglasnegocio.entidades.ActividadCatalogo;
import reglasnegocio.entidades.ActividadProgramada;
import reglasnegocio.entidades.Salon;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 * Contiene los metodos que acceden a la capa de conexion con respecto a la 
 * clase actividadProgramada.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class ActividadProgramadaDAO implements IActividadProgramadaDAO{
    
    private Connection conexion;
    private PreparedStatement sentenciaSQL;
    
    /**
     * Extrae de la base de datos todos las actividades que tiene asignas un
     * asesor en especifico.
     * 
     * @param numPersonal identificador unico del asesor
     * @param idEE identificador unico de una experiencia educativa
     * @param lapso rango de busqueda de las actividades ya se han las del dia
     * o la semana
     * @see ActividadProgramada
     * @see ActividadProgramada#filtrarActividades(List, String) 
     * @return regresa las actividades programada para la actual o futuras
     * fechas.
     */
    @Override
    public List<ActividadProgramada> sacarActividadesProgramadas(String numPersonal, String idEE, String lapso) throws SQLException,IOException{
        List<ActividadProgramada> actividades = new ArrayList();
        
        try{
            conexion = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexion.prepareStatement("Select actividadProgramada.idActividadProgram, actividadCatalogo.nombreActiv"
                    + "idad,actividadProgramada.fechaRealizar, actividadProgramada.horaini, actividadProgramada.horafin,salon.nomb"
                    + "reSalon,actividadProgramada.estado from ActividadCatalogo, ActividadProgramada, Salon, ee, asesor where asesor.numPersonal = ? "
                    + "and ee.idee = ? and ee.idee = actividadCatalogo.idee and actividadProgramada.idsalon = salon.idSalon "
                    + "and actividadProgramada.idActividad = actividadCatalogo.idactividad and asesor.numpersonal = actividadProg"
                    + "ramada.numpersonal");
            
            sentenciaSQL.setString(1, numPersonal);
            sentenciaSQL.setString(2, idEE);
            
            ResultSet tablaSQL = sentenciaSQL.executeQuery();
            
            while(tablaSQL.next()){
                
                ActividadProgramada actividad = new ActividadProgramada();
                actividad.setIdActividadProgramada(tablaSQL.getString(1));
                
                ActividadCatalogo actividadCatalogo = new ActividadCatalogo();
                actividadCatalogo.setNombre(tablaSQL.getString(2));
                
                actividad.setActividad(actividadCatalogo);
                actividad.setFechaRealizar(tablaSQL.getString(3));
                actividad.setHoraInicio(tablaSQL.getString(4));
                actividad.setHoraFin(tablaSQL.getString(5));
                
                Salon salon = new Salon();
                salon.setNombreSalon(tablaSQL.getString(6));
                
                actividad.setSalon(salon);
                actividad.setEstado(tablaSQL.getBoolean(7));
                
                actividades.add(actividad);
            }
            
        } catch (SQLException ex) {
            throw new SQLException("Error al consultar las actividades",ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error con el archivo de la base de datos",ex);
        } finally{
            
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion a la base de datos",ex);
            }
        }
        
        actividades = ActividadProgramada.filtrarActividades(actividades, lapso);
        
        return actividades;
    }
    
}
