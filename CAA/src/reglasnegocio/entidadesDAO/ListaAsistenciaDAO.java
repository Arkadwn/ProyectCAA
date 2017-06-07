package reglasnegocio.entidadesDAO;

import conexionbdd.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reglasnegocio.asesor.IListaAsistenciaDAO;
import reglasnegocio.entidades.ListaAsistencia;
import reglasnegocio.entidades.UsuarioAutonomo;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 * Contiene los metodos para el acceso a la capa de conexion con respecto a la
 * clase ActividadProgramada.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 */
public class ListaAsistenciaDAO implements IListaAsistenciaDAO{
    
    private Connection conexion;
    private PreparedStatement sentenciaSQL;
    
    /**
     * Guarda la asistencia de los usuariosAutonomos ademas de la fecha de la
     * ultima modificacion.
     * 
     * @param asistencia son todos los Usuarios autonomos dentro de la actividad
     * asi como la actividad realizada.
     * @return confirmacion de la operacion realizada.
     * @throws SQLException Se lanza cuando hay un error al momento de la
     * modificacion en la base de datos.
     * @throws IOException Se lanza cuando ocurre un error con el archivo que
     * guarda los daots de la base de datos.
     * @see ListaAsistencia
     */
    @Override
    public boolean guardarListaAsistencia(ListaAsistencia asistencia) throws SQLException, IOException{
        int i = 0;
        boolean confirmacion = false;
        
        try{
            conexion = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            for(UsuarioAutonomo alumno:asistencia.getListaAsistencia()){
                sentenciaSQL = conexion.prepareStatement("Update listaAsistencia set asistencia = ?, fechamodificacion = ? where listaasistencia.matricula = ? and listaasistencia.idactividadProgram = ?");
                sentenciaSQL.setBoolean(1, asistencia.getAsistencia()[i]);
                sentenciaSQL.setString(2, asistencia.getFechaModificacion());
                sentenciaSQL.setString(3, alumno.getMatricula());
                sentenciaSQL.setString(4, asistencia.getActividad().getIdActividadProgramada());
                
                sentenciaSQL.executeUpdate();
                
                i++;
            }
            
            confirmacion = true;
            
        }catch(SQLException ex){
            throw new SQLException("Error al guardar los datos",ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error con el archivo que guarda la configuracion de la base de datos",ex);
        }finally{
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion a la base de datos",ex);
            }
        }
        
        return confirmacion;
    }

    /**
     * Regresa una la lista de asistencia de acuerdo a una actividadProgramada.
     * La cual esta integrada por una lista de usuarioAutonomo.
     * 
     * @param idActividad Identificador de la activdadProgramada
     * @return Regresa la lista de asistencia.
     * @throws SQLException Se lanza cuando hay un error cuando se sacan los
     * valores de la base de datos.
     * @throws IOException Se lanza cuando hay un error con el archivo el cual
     * contiene las propiedades de la base de datos.
     * @see UsuarioAutonomo
     */
    @Override
    public ListaAsistencia sacarListaAsistencia(String idActividad) throws SQLException, IOException {
        ListaAsistencia asistencia = null;
        List<UsuarioAutonomo> asistentes = new ArrayList();
        UsuarioAutonomo usuarioAutonomo;
        int i = 0;
        Boolean[] lista = new Boolean[50];
        
        
        try{
           conexion = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
           sentenciaSQL = conexion.prepareStatement("SELECT usuarioAutonomo.matricula,usuarioAutonomo.nombre,usuarioAutonomo.apellidoPaterno,"
                   + "usuarioAutonomo.apellidoMaterno, listaAsistencia.asistencia from usuarioAu"
                   + "tonomo,actividadProgramada,listaAsistencia where listaAsistencia.matricula = usuarioAutonomo.matricula"
                   + " and actividadProgramada.idActividadProgram = ? and actividadProgramada.idActividadProgram = lis"
                   + "taAsistencia.idActividadProgram");
           sentenciaSQL.setString(1, idActividad);
           
           ResultSet tablaSQL = sentenciaSQL.executeQuery();
           
           asistencia = new ListaAsistencia();
           
           while(tablaSQL.next()){
               usuarioAutonomo = new UsuarioAutonomo();
               
               
               usuarioAutonomo.setMatricula(tablaSQL.getString(1));
               usuarioAutonomo.setNombre(tablaSQL.getString(2));
               usuarioAutonomo.setApellidoPaterno(tablaSQL.getString(3));
               usuarioAutonomo.setApellidoMaterno(tablaSQL.getString(4));
               
               lista[i] = tablaSQL.getBoolean(5);
               
               asistentes.add(usuarioAutonomo);
               i++;
               
           }
           
           asistencia.setListaAsistencia(asistentes);
           asistencia.setAsistencia(lista);
           
        }catch(SQLException ex){
            throw new SQLException("Error al guradar la asistencai de los usuarios autonomos",ex);
        }catch(IOException | ClassNotFoundException ex){
            throw new IOException("Error con el archivo de la base datos",ex);
        }finally{
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion a la base de datos",ex);
            }
        }
        
        return asistencia;
    }

    /**
     * Valida si ya se ha tomado lista de asistencia anteriormente.
     * 
     * @param idActividad identificador unico de la actividadProgramada
     * @return validacion de la tarea
     * @throws java.sql.SQLException Se lanza cuando hay un error al sacar
     * informacion de la base de datos.
     * @throws java.io.IOException Se lanza cuando hay error con
     * el archivo que contiene la configuracion de la base de datos.
     */
    @Override
    public boolean verificarAntecedentes(String idActividad) throws SQLException, IOException {
        /*Si es verdadero se ha pasado lista*/
        boolean confirmacion = false;
        
        try{
            conexion = new Conexion().getConexion(UtileriasConexionBDD.obtenerDatosBDD());
            sentenciaSQL = conexion.prepareStatement("SELECT listaAsistencia.fechaModificacion from listaAsistencia where listaAsistencia.idActividadProgram = ?");
            sentenciaSQL.setString(1, idActividad);
            
            ResultSet tablaSQL = sentenciaSQL.executeQuery();
            
            if(tablaSQL.next()){
                
                if(tablaSQL.getString(1) != null){
                    confirmacion = true;
                }
            
            }
            
        }catch(SQLException ex){
            throw new SQLException("Error al extraer datos de la base de datos",ex);
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("Error en el archivo que contiene los datos de la base de datos",ex);
        } finally{
            try {
                new Conexion().cerrarConexion(conexion);
            } catch (SQLException ex) {
                throw new SQLException("Error al cerrar la conexion de la base de datos",ex);
            }
        }
        
        return confirmacion;
    }
    
}
