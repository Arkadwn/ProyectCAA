package reglasnegocio.utilerias;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Contiene el acceso al log4j.
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class Bitacora {
    
    /***
     * Realiza una decicion para especificar el nivel de log y como se agregara
     * al log.
     * 
     * @param clase hace referencia a la clase de donde proviene el mensaje
     * @param nivel declara el nivel que tiene el evento ocurrido
     * @param mensaje declaracion que se agrega al log, en cual contiene la
     * informacion de lo sucedido.
     */
    public static void guardarBitacora(Class clase,String nivel, String mensaje){
        Logger log = LogManager.getLogger(clase);
        
        switch(nivel){
            case "INFO":
                log.info(mensaje);
                break;
            case "FATAL":
                log.fatal(mensaje);
                break;
            case "Error":
                log.error(mensaje);
                break;
            case "WARN":
                log.warn(mensaje);
                break;
            case "DEBUG":
                log.debug(mensaje);
                break;
            default:
                break;
        }
    }
}
