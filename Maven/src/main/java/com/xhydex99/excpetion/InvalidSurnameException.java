package com.xhydex99.excpetion;

public class InvalidSurnameException extends RuntimeException {
    public InvalidSurnameException(String message) {
        super(message);
    }
}
