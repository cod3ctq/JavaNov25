package exceptions;

public class AccountNotExitException extends RuntimeException {
    public AccountNotExitException(String message) {
        super(message);
    }
}
