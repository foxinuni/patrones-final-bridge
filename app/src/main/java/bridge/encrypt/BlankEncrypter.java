package bridge.encrypt;

public class BlankEncrypter implements Encrypter {
    @Override
    public String encrypt(String message, String password) throws Exception {
        return message;
    }
}
