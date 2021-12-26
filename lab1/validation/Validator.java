package validation;

public class Validator {
    private String menuItemRegex;
    private String pathRegex;
    private String filenameRegex;

    public Validator(String menuItemRegex, String pathRegex, String filenameRegex) {
        this.menuItemRegex = menuItemRegex;
        this.pathRegex = pathRegex;
        this.filenameRegex = filenameRegex;
    }

    public Validator() {
        this.menuItemRegex = "^[1-2]$";
        this.pathRegex = "^[A-Z]{1}[:]{1}([\\\\]{1}(\\w|\\s)+)+$";
        this.filenameRegex = "^\\w+[.]*\\w*$";
    }

    public void validateMenuItem(String input) throws InvalidItemFormat {
        if (input.equals("")) {
            throw new InvalidItemFormat("field shouldn't be empty");
        } else { 
            if (!input.matches(menuItemRegex)) {
                throw new InvalidItemFormat("incorrect input menu item format");
            }
        }
    }

    public void validatePath(String input) throws InvalidItemFormat {
        if (input.equals("")) {
            throw new InvalidItemFormat("field shouldn't be empty");
        } else { 
            if (!input.matches(pathRegex)) {
                throw new InvalidItemFormat("incorrect path format");
            }
        }
    }

    public void validateChar(String input) throws InvalidItemFormat {
        if (input.equals("")) {
            throw new InvalidItemFormat("field shouldn't be empty");
        } else {
            if (input.length() > 1) {
                throw new InvalidItemFormat("only single chars are accepatable");
            }
        }
    }

    public void validateFilename(String input) throws InvalidItemFormat {
        if (input.equals("")) {
            throw new InvalidItemFormat("field shouldn't be empty");
        } else { 
            if (!input.matches(filenameRegex)) {
                throw new InvalidItemFormat("incorrect filename format");
            }
        }
    }
}
