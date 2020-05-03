package com.bridgelabz.greetingapp.exception;

public class GreetingAppException extends Throwable {
    ExceptionType type;

    public GreetingAppException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        ID_NOT_FOUND;
    }

}
