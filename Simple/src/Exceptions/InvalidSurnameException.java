package exceptions;

public class InvalidSurnameException extends RuntimeException {
    public InvalidSurnameException(String message) {
        super(message);
    }
}
