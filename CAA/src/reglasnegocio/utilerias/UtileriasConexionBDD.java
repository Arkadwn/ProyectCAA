package reglasnegocio.utilerias;

import conexionbdd.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import reglasnegocio.DatosConexionBDD;

/**
 * Define los metodos que guardaran la informacion para la conexión a la BDD por
 * medio de la Serialización y otros metodos para la seguridad de las
 * contraseñas.
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez
 */
public class UtileriasConexionBDD {

    /**
     * Realiza serialización de los datos introducidos para su posterior uso en
     * la conexion a la BDD.
     *
     * @param iP Direccion IP del servidor a conectar
     * @param usuario Cuenta del usuario en la BB a conectarse
     * @param contraseña Contraseña del usuario en la BDD
     */
    public static void serializarDatosBDD(String iP, String usuario, byte[] contraseña) throws FileNotFoundException, IOException {
        DatosConexionBDD datos = new DatosConexionBDD();
        datos.setDireccionIP(iP);
        datos.setUsuario(usuario);

        datos.setContraseña(contraseña);//Proteger contraseña       
        FileOutputStream archivo = new FileOutputStream("/Archivos/dataBDD.ser");
        ObjectOutputStream stream = new ObjectOutputStream(archivo);
        stream.writeObject(datos);
        stream.close();
    }

    /**
     * Realiza la lectura del archivo serializable que contiene los datos
     * almacenados de la conexion a la BDD.
     *
     * @return Arreglo de tipo String de tipo DatosConexionBDD que contiene
     * los datos de acceso
     */
    public static String[] obtenerDatosBDD() throws FileNotFoundException, IOException, ClassNotFoundException {
        DatosConexionBDD dataBDD = null;
        FileInputStream archivo = new FileInputStream("/Archivos/dataBDD.ser");
        ObjectInputStream stream = new ObjectInputStream(archivo);
        dataBDD = (DatosConexionBDD) stream.readObject();
        stream.close();
        String[] datos = new String[3];
        datos[0] = dataBDD.getDireccionIP();
        datos[1] = dataBDD.getUsuario();
        try {
            datos[2] = UtileriasEncriptado.descifra(dataBDD.getContraseña());
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UtileriasConexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UtileriasConexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UtileriasConexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    /**
     * Comprueba si es posible la conexion a la BDD con los datos enviados si la
     * conexion es correcta regresa un true.
     *
     * @param iP Direccion IP del servidor a conectar
     * @param usuario Cuenta del usuario en la BB a conectarse
     * @param contraseña Contraseña del usuario en la BDD
     * @return Bandera de comprobacion de acceso a la BDD
     * @throws SQLException Puede ocurrir al no poder conectar o en caso que el
     * exista una dificultad al conectar o desconectar.
     */
    public static boolean comprobarConexionBDD(String iP, String usuario, String contraseña) throws SQLException {
        Connection conexion = null;
        try {
            conexion = new Conexion().getConexion(iP, usuario, contraseña);
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL: " + sqlEx.getMessage());
        }
        boolean banderaConexion = conexion.isValid(0);
        try {
            Conexion cerrarConex = new Conexion();
            cerrarConex.cerrarConexion(conexion);
        } catch (SQLException sqlEx) {
            System.out.println("Error SQL: " + sqlEx.getMessage());
        }
        return banderaConexion;
    }
}
