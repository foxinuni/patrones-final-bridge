package bridge.encrypt;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

public class DESEncrypter implements Encrypter {
    @Override
    public String encrypt(String message, String password) throws Exception {
        final Base64.Encoder encoder = Base64.getEncoder();
        final DESKeySpec dks = new DESKeySpec(message.getBytes());
        final SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        final SecretKey desKey = skf.generateSecret(dks);

        final Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);

        byte[] encrypted = desCipher.doFinal(message.getBytes());
        return encoder.encodeToString(encrypted);
    }
}
