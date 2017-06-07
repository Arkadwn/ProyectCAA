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
import reglasnegocio.asesor.IActividadProgramadaDAO;
import reglasnegocio.entidades.ActividadCatalogo;
import reglasnegocio.entidades.ActividadProgramada;
import reglasnegocio.entidades.Salon;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 *
 * @author Leonardo
 */
public class ActividadProgramadaDAO implements IActividadProgramadaDAO{
    
    Connection conexion;
    PreparedStatement sentenciaSQL;
    
    /**
     * 
     * @param numPersonal
     * @param idEE
     * @param lapso
     * @return 
     */
    @Override
    public List<ActividadProgramada> sacarActividadesProgramadas(String numPersonal, String idEE, String lapso) {
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
            Logger.getLogger(ActividadProgramadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadProgramadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(ActividadProgramadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        actividades = ActividadProgramada.filtrarActividades(actividades, lapso);
        
        return actividades;
    }
    
}
