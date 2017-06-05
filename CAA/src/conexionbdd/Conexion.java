package conexionbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hace la conexion del sistema con la BDD utilizando el driver de SQL, de tal 
 * manera que solo se logre instanciar el objeto para lograr la conexion y 
 * esta capa tener acceso a el manejo de datos.
 * 
 * @see Conexion
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez Jimenez
 * @version 27/03/2017
 */
public class Conexion {
    private Connection conexion = null;

    /**
     * Genera la conexion a la BDD.
     * @param datosBDD Arreglo de String con los datos necesarios para la
     * conexion a la bdd, como lo es la IP, el usuario y la contraseña.
     * @return instancia de la clase que hace la conexion a la BDD
     */
    public Connection getConexion(String[] datosBDD) throws SQLException {
        String iP = datosBDD[0]; 
        String usuario = datosBDD[1];
        String contraseña = datosBDD[2];
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error en driver: " + ex.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://"+iP+"/caa?" 
                    + "user="+usuario+"&password="+contraseña);
        } catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
            throw new SQLException(sqlEx.getMessage(), sqlEx);
        }
        return conexion;
    }

    /**
     * Cierra la conexion a la BDD. 
     */
    public void cerrarConexion(Connection conexion) throws SQLException{
        try{
            conexion.close();
        }catch (SQLException sqlEx) {
            System.out.println("SQLException: " + sqlEx.getMessage());
            throw new SQLException(sqlEx.getMessage(), sqlEx);
        }
    }
    
}
