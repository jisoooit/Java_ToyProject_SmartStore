package me.java.project.exception;

public class InputRangeException extends  Exception{
    public InputRangeException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
    }

    public InputRangeException(String message) {
        super(message);
    }
}
