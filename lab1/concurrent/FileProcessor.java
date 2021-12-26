package concurrent;

import java.nio.file.Files;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FileProcessor implements Callable<String> {
    private File dir;
    private char symbol;
    ExecutorService pool;

    public FileProcessor(File dir, char symbol, ExecutorService pool) {
        this.dir = dir;
        this.symbol = symbol;
        this.pool = pool;
    }

    public int search(File ff) {
        try (Scanner sc = new Scanner(new FileInputStream(ff))) {
            int matchesAmount = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                if (!str.trim().isEmpty() && str.trim().charAt(0) == this.symbol) {
                    matchesAmount++;
                }
            }
            return matchesAmount;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return 0;
        }
    }

    public String call() {
        String previousResult = "";
        String currentResult = "";
        try {
            List<Future<String>> fres = new ArrayList<>();
            File[] files = dir.listFiles();
            for (File ff : files) {
                if (ff.isDirectory()) {
                    FileProcessor fproc = new FileProcessor(ff, symbol, pool);
                    fres.add(pool.submit(fproc));
                } else {
                    if (Files.probeContentType(ff.toPath()) != null && Files.probeContentType(ff.toPath()).contains("text")) {
                        currentResult += ff.toString() + " -> " + Integer.toString(search(ff)) + '\n';
                    }
                }
            }
            for (Future<String> res : fres) {
                previousResult += res.get();
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return (previousResult + currentResult);
    }
}
