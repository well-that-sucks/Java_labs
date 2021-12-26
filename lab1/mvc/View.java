package mvc;

public class View {
    public final String MENU_CHOOSE_MSG = "Choose a number: ";
    public final String MENU_MSG = (
        "1. Continue\n" +
        "2. Exit\n"
    );
    public final String INVALID_OPTION_MSG = "Invalid option\n";
    public final String ENTER_PATH_MSG = "Enter path: ";
    public final String ENTER_SYMBOL_MSG = "Enter symbol to be searched: ";
    public final String ENTER_FILENAME_MSG = "Enter filename for the output to be saved to: ";

    public void print(String message) {
        System.out.print(message);
    }

    public void printLine() {
        System.out.print("\n");
    }

}
