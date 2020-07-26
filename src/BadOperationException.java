
public class BadOperationException extends Exception {
    public BadOperationException() { super(); }
    public BadOperationException(String message) { super(message); }
    public BadOperationException(String message, Throwable cause) { super(message, cause); }
    public BadOperationException(Throwable cause) { super(cause); }
}