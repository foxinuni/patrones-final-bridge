package bridge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import bridge.encrypt.Encrypter;

public class EncrypterFactory {
    public static Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = EncrypterFactory.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("Unable to find " + fileName);
            }
            properties.load(input);
        }
        return properties;
    }
    

    public static Encrypter createEncrypter(String fileName) throws Exception {
        // Se lee del archivo properties
        Properties properties = loadProperties(fileName);
        String encrypterName = properties.getProperty("encrypter");
        
        // Se carga la clase
        Class<?> encrypterClass = Class.forName(encrypterName);

        // Se castea a un encrypter y se devuelve
        Encrypter encrypter = (Encrypter) encrypterClass
            .getDeclaredConstructor()
            .newInstance();

        return new EncryptBridge(encrypter);
    }
}
