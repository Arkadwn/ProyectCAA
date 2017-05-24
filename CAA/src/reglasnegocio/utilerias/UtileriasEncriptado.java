package reglasnegocio.utilerias;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Define la clase que implementa metodos para la encriptación y desencriptación 
 * de cadenas.
 * 
 * @author https://gist.github.com/arturotena/
 */
public class UtileriasEncriptado {
/**
 * Retorna un arreglo de bytes que es el resultado del cifrado de la cadena que 
 * se le pasa al metodo como parametro.
 * 
 * @param sinCifrar Cadena que se desea cifrar
 * @return Arreglo de bytes que equivalen a el cifrado del parametro
 * @throws Exception 
 * @throws UnsupportedEncodingException 
 * @throws IllegalBlockSizeException 
 * @throws BadPaddingException
 */
    public static byte[] cifra(String sinCifrar) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception {
        final byte[] bytes = sinCifrar.getBytes("UTF-8");
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }
/**
 * Retorna un la cadena resultante de el descifrar el arreglo de bytes[] que se
 * le pasa al metodo como parametro
 * 
 * @param cifrado Arreglo de bytes que equivale a la cadena cifrada
 * @return La cadena resultande del proceso de decifrar el arreglo de bytes[]
 * @throws UnsupportedEncodingException
 * @throws IllegalBlockSizeException
 * @throws BadPaddingException
 * @throws Exception 
 */
    public static String descifra(byte[] cifrado) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        final String sinCifrar = new String(bytes, "UTF-8");
        return sinCifrar;
    }
/**
 * Retorna un objeto Cipher que sirve como llave para encriptar o desencriptar
 * segun el parametro boolean que se envia.
 * 
 * @param paraCifrar Bandera booleana que sirve como identificador para obtener
 * el objeto Cipher iniciado para cifrar o decifrar segun el valor de la bandera.
 * @return Objeto Cipher que funciona como llave de cifrar o decifrar.
 * @throws NoSuchAlgorithmException
 * @throws UnsupportedEncodingException
 * @throws NoSuchPaddingException
 * @throws InvalidKeyException 
 */
    private static Cipher obtieneCipher(boolean paraCifrar) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException{
        final String frase = "¡8478877f1bbd9f871e46ad4a4645804aabd13cd6ad63a657be9860d3a9d6a46c!";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(frase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }
}
