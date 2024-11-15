package bridge;

import bridge.encrypt.Encrypter;

public class EncryptBridge implements Encrypter {
    private Encrypter encrypter;

    public EncryptBridge(Encrypter encrypter) {
        this.encrypter = encrypter;
    }

    @Override
    public String encrypt(String message, String password) throws Exception {
        System.out.printf("Now encrypting with %s (plaintext: %s, secret: %s)\n", encrypter.getClass().getName(), message, password);
        return encrypter.encrypt(message, password);
    }
}
