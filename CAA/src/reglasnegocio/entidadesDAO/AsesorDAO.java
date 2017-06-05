package reglasnegocio.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import reglasnegocio.entidades.Asesor;
import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reglasnegocio.asesor.IAsesorDAO;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class AsesorDAO implements IAsesorDAO{
    
    PreparedStatement sentenciaSQL;
    Connection conexion;
    ResultSet tablaSQL;
    
    /**
     * 
     * 
     * @param nombreUsuario
     * @return 
     */
    @Override
    public Asesor sacarDatosAsesor(String nombreUsuario) {
        Asesor asesor = null;
        String[] datosBDD = new String[3];
        
        try{
            datosBDD = UtileriasConexionBDD.obtenerDatosBDD();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AsesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            conexion = new Conexion().getConexion(datosBDD);
            sentenciaSQL = conexion.prepareStatement("Select nombre, apellidoPaterno, apellidoMaterno, numPersonal, idiomaIngles, idiomaFrances from asesor where nombreUsuario = ?");
            sentenciaSQL.setString(1, nombreUsuario);
            
            tablaSQL = sentenciaSQL.executeQuery();
            
            if(tablaSQL.next()){
                asesor = new Asesor();
                asesor.setNombre(tablaSQL.getString(1));
                asesor.setApellidoPaterno(tablaSQL.getString(2));
                asesor.setApellidoMaterno(tablaSQL.getString(3));
                asesor.setNumeroPersonal(tablaSQL.getString(4));
                asesor.setIdiomaIngles(tablaSQL.getBoolean(5));
                asesor.setIdiomaFrances(tablaSQL.getBoolean(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(AsesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return asesor;
    }
}
