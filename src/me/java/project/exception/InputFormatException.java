package me.java.project.exception;

public class InputFormatException extends IllegalArgumentException{
    public InputFormatException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
    }

    public InputFormatException(String message) {
        super(message);
    }
}
