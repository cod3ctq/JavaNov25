package Exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }

    public static class AccountNoExistException extends RuntimeException {
        public AccountNoExistException(String message) {
            super(message);
        }
    }
}
