package reglasnegocio.utilerias;

import conexionbdd.Conexion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reglasnegocio.DatosConexionBDD;

/**
 * Define los metodos que guardaran la informacion para la conexión a la BDD 
 * por medio de la Serialización y otros metodos para la seguridad de las
 * contraseñas.
 * 
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class UtileriasConexionBDD {
    private ResultSet resultado;
    private PreparedStatement sentencia;
    /**
     * Realiza serialización de los datos introducidos para su posterior uso en
     * la conexion a la BDD.
     * 
     * @param iP Direccion IP del servidor a conectar
     * @param usuario Cuenta del usuario en la BB a conectarse
     * @param contraseña Contraseña del usuario en la BDD
     */
    public void serializarDatosBDD(String iP, String usuario, String contraseña) {
        DatosConexionBDD datos = new DatosConexionBDD();
        datos.setDireccionIP(iP);
        datos.setUsuario(usuario);
        
        datos.setContraseña(contraseña);//Proteger contraseña
        try {
            FileOutputStream archivo = new FileOutputStream("/Archivos/dataBDD.ser");
            ObjectOutputStream stream = new ObjectOutputStream(archivo);
            stream.writeObject(datos);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Realiza la lectura del archivo serializable que contiene los datos 
     * almacenados de la conexion a la BDD.
     * 
     * @return Objeto de tipo DatosConexionBDD que contiene los datos de acceso
     */
    public DatosConexionBDD obtenerDatosBDD() {
        DatosConexionBDD dataBDD = null;
        try {
            FileInputStream archivo = new FileInputStream("/Archivos/dataBDD.ser");
            ObjectInputStream stream = new ObjectInputStream(archivo);
            dataBDD = (DatosConexionBDD) stream.readObject();
            stream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error" + e.getMessage());   
        }
        return dataBDD;
    }
    /**
     * Comprueba si es posible la conexion a la BDD con los datos enviados
     * si la conexion es correcta regresa un true.
     * 
     * @param iP Direccion IP del servidor a conectar
     * @param usuario Cuenta del usuario en la BB a conectarse
     * @param contraseña Contraseña del usuario en la BDD
     * @return Bandera de comprobacion de acceso a la BDD
     * @throws SQLException Puede ocurrir al no poder conectar o en caso que el
     * exista una dificultad al conectar o desconectar.
     */
    public boolean comprobarConexionBDD(String iP, String usuario, String contraseña) throws SQLException{
        Connection conexion=null;
        try {
            conexion = new Conexion().getConexion(iP, usuario, contraseña);
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL: " + sqlEx.getMessage());
        }
        boolean banderaConexion = conexion.isValid(0);
        try{
        Conexion cerrarConex = new Conexion();
        cerrarConex.cerrarConexion(conexion);
        }catch(SQLException sqlEx){
            System.out.println("Error SQL: "+sqlEx.getMessage());
        }
        return banderaConexion;
    }
}
