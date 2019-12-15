package pl.irybchuk.service.Exception;

public class UserNotAdultException extends Exception {
    private String message;

    public UserNotAdultException(String message) {
        super(message);
        this.message = message;
    }
}
