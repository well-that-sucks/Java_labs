package validation;

public class InvalidItemFormat extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidItemFormat(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return ("InvalidItemFormatException: " + getMessage());
    }
}
