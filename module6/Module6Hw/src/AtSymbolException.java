//Exception class
//CS211s Jacky Choi
public class AtSymbolException extends Exception {
    public static final String MESSAGE = "Name is invalid";

    public AtSymbolException() {
        super(MESSAGE);
    }
    public AtSymbolException(String message) {
        super(message);
    }
}
