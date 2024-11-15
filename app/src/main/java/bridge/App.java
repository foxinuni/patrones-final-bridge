package bridge;

import bridge.encrypt.Encrypter;

public class App {
    private static final String FILE_NAME = "config.properties";

    public static void main(String[] args) throws Exception {
        // Se obtiene la clase utilizando el factory
        final Encrypter encrypt = EncrypterFactory.createEncrypter(FILE_NAME);

        // Se encripta
        String encrypted = encrypt.encrypt("Hello World!", "HG58YZ3CR9123456");
        System.out.println("Encrypted: " + encrypted);
    }
}
