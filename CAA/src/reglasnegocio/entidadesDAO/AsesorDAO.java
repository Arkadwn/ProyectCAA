package reglasnegocio.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import reglasnegocio.entidades.Asesor;
import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.SQLException;
import reglasnegocio.asesor.IAsesorDAO;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 * Contiene los metodos para el acceso a la capa de conexion referentes a la 
 * clase Asesor.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 * @see Asesor
 */
public class AsesorDAO implements IAsesorDAO{
    
    private PreparedStatement sentenciaSQL;
    private Connection conexion;
    private ResultSet tablaSQL;
    
    /**
     * Extrae de la base de datos todos los datos de un asesor en especifico.
     * 
     * @param nombreUsuario identificador del asesor
     * @return regresa un Objeto Asesor el cual contiene todos los datos de un 
     * asesor.
     */
    @Override
    public Asesor sacarDatosAsesor(String nombreUsuario) throws SQLException, IOException{
        Asesor asesor = null;
        String[] datosBDD = new String[3];
        
        try{
            conexion = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
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
            throw new SQLException("Error al realizar la consulta", ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error con el archivo de datos BDD", ex);
        } finally{
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion a la base de datos", ex);
            }
        }
        
        return asesor;
    }
}
