package Exceptions;

public class InvalidCityException extends RuntimeException {
  public InvalidCityException(String message) {
    super(message);
  }
}
