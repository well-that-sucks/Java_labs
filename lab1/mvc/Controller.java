package mvc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import validation.*;
import concurrent.FileProcessor;

public class Controller {
    private View view;
    private Validator validator;

    public Controller() {
        this.view = new View();
        this.validator = new Validator();
    }
    
    public void start() {
        Scanner sc = new Scanner(System.in);
        view.print(view.MENU_MSG);
        String enteredData = getValidMenuItem(sc);
        ExecutorService pool = Executors.newCachedThreadPool();
        while (!enteredData.equals("2")) {
            switch (enteredData) {
                case "1":
                    String path = getValidPath(sc);
                    char symbol = getValidChar(sc);
                    FileProcessor fproc = new FileProcessor(new File(path), symbol, pool);
                    Future<String> fres = pool.submit(fproc);
                    String result = new String();
                    try {
                        result = fres.get();
                    } catch (Exception e) {
                        view.print(e.toString());
                    }
                    String filename = getValidFilename(sc);
                    writeResultToFile(filename, result);
                    view.print(readContentsOfFile(filename));
                    view.printLine();
                    break;
                case "2":
                    break;
                default:
                    view.print(view.INVALID_OPTION_MSG);
                    view.printLine();
            }
            view.print(view.MENU_MSG);
            enteredData = getValidMenuItem(sc);
        }
        pool.shutdown();
        sc.close();
    }

    public String getValidMenuItem(Scanner sc) {
        boolean isInputValid = false;
        String menuItem = new String();
        while (!isInputValid) {
            try {
                view.print(view.MENU_CHOOSE_MSG);
                menuItem = sc.nextLine().trim();
                validator.validateMenuItem(menuItem);
                isInputValid = true;
            } catch (Exception e) {
                view.print(e.toString());
                view.printLine();
            }
        }
        return menuItem;
    }

    public String getValidPath(Scanner sc) {
        boolean isInputValid = false;
        String path = new String();
        while (!isInputValid) {
            try {
                view.print(view.ENTER_PATH_MSG);
                path = sc.nextLine().trim();
                validator.validatePath(path);
                isInputValid = true;
            } catch (Exception e) {
                view.print(e.toString());
                view.printLine();
            }
        }
        return path;
    }

    public char getValidChar(Scanner sc) {
        boolean isInputValid = false;
        String charLine = new String();
        while (!isInputValid) {
            try {
                view.print(view.ENTER_SYMBOL_MSG);
                charLine = sc.nextLine().trim();
                validator.validateChar(charLine);
                isInputValid = true;
            } catch (Exception e) {
                view.print(e.toString());
                view.printLine();
            }
        }
        return charLine.charAt(0);
    }

    public String getValidFilename(Scanner sc) {
        boolean isInputValid = false;
        String filename = new String();
        while (!isInputValid) {
            try {
                view.print(view.ENTER_FILENAME_MSG);
                filename = sc.nextLine().trim();
                validator.validateFilename(filename);
                isInputValid = true;
            } catch (Exception e) {
                view.print(e.toString());
                view.printLine();
            }
        }
        return filename;
    }

    public void writeResultToFile(String filename, String result) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(result);
            fw.close();
        } catch (Exception e) {
            view.print(e.toString());
            view.printLine();
        }
    }

    public String readContentsOfFile(String filename) {
        String result = "";
        try {
            FileReader fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                result += line + '\n';
            }
            sc.close();
            fr.close();
        } catch (Exception e) {
            view.print(e.toString());
            view.printLine();
        }
        return result;
    }
}
