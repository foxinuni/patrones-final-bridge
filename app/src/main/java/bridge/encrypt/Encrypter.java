package bridge.encrypt;

public interface Encrypter {
    String encrypt(String message, String password) throws Exception;
}
