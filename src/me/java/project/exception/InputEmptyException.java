package me.java.project.exception;

public class InputEmptyException extends IllegalArgumentException{
    public InputEmptyException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
