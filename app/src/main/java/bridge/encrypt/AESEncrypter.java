package bridge.encrypt;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypter implements Encrypter {
    @Override
    public String encrypt(String message, String password) throws Exception {
        // Se crea el conversor base64
        final Base64.Encoder encoder = Base64.getEncoder();

        // Se crea la llave segun la contrase;a
        final Key key = new SecretKeySpec(password.getBytes(), "AES");
        
        // Se crea el cipher
        final Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Se encripta el valor
        byte[] encrypted = cipher.doFinal(message.getBytes());

        // Se devuelve el encriptado
        return encoder.encodeToString(encrypted);
    }
}
