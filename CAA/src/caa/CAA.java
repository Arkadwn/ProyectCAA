package caa;

import interfazusuario.CofigurarBDD;
import interfazusuario.IniciarSesion;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import reglasnegocio.utilerias.UtileriasConexionBDD;

/**
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimenez Jimenez
 */
public class CAA {
    public static void main(String[] args) {
        File archivo = new File(UtileriasConexionBDD.obtenerDirectorioSO(true));
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
