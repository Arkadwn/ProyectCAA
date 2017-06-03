package caa;

import interfazusuario.CofigurarBDD;
import interfazusuario.IniciarSesion;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez Jimenez
 */
public class CAA {
    public static void main(String[] args) {
     String nombreSO = System.getProperty("os.name");
        File archivo;
        if (!"Linux".equals(nombreSO)) {
            archivo = new File("C:\\Archivos\\dataBDD.ser");
        } else {
            archivo = new File("/Archivos/dataBDD.ser");
        }
        if (archivo.exists()) {
            new IniciarSesion().setVisible(true);
        }else{
         try {
             new CofigurarBDD().setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(CAA.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
}
