package exceptions;

public class InvalidBirthdateException extends RuntimeException {
    public InvalidBirthdateException(String message) {
        super(message);
    }
}
