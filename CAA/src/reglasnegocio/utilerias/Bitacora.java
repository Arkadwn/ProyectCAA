package reglasnegocio.utilerias;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class Bitacora {
    
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
