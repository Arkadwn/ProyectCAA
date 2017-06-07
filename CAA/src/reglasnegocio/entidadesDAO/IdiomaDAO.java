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
import reglasnegocio.entidades.Idioma;
import reglasnegocio.utilerias.UtileriasConexionBDD;
import reglasnegocio.coordinador.IIdiomaDAOCoord;

/**
 * Implementa todos los metodos que son definidos en la interfaz que implementa,
 * declara los metodos que hacen diversos tipos de busquedas, selección de los
 * idiomas; en coordinación con la capa de conexionbdd para su uso en capa 
 * superior o de su mismo nivel.
 * 
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class IdiomaDAO implements IIdiomaDAOCoord, IIdiomaDAOAsesor{

    private ResultSet resultadoSQL;
    private PreparedStatement sentenciaSQL;
    private Connection conexionBDD;
    
    /**
     * Muestra todos los idiomas actuales guardados en la base de datos.
     * 
     * @return Lista de todos los Idiomas guardados actualmente en la BDD
     * @throws SQLException
     * @throws IOException
     */
    public List<Idioma> mostrarIdiomasActuales() throws SQLException, IOException{
        List<Idioma> listaIdiomas = new ArrayList<>();
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
        }finally{
            try {
                new Conexion().cerrarConexion(conexionBDD);
            } catch (SQLException ex) {
                Logger.getLogger(ExperEduDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al cerrar la conexión a la BDD al mostrar los idiomas actuales", ex);
            }
        }
        return listaIdiomas;
    }
    
}
