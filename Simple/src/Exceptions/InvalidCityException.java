package exceptions;

public class InvalidCityException extends RuntimeException {
  public InvalidCityException(String message) {
    super(message);
  }
}
