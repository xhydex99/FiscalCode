package com.xhydex99.excpetion;

public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException(String message) {
        super(message);
    }
}
