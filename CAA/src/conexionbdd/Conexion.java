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
    private Connection con = null;

    /**
     * Genera la conexion a la BDD.
     * @return instancia de la clase que hace la conexion a la BDD
     */
    public Connection getConexion(String iP, String usuario, String contraseña) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error en driver: " + ex.getMessage());
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+iP+"/ss?" 
                    + "user="+usuario+"&password="+contraseña);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return con;
    }

    /**
     * Cierra la conexion a la BDD. 
     */
    public void cerrarConexion(){
        try{
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
