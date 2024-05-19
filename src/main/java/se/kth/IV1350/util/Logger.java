package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private String path = "log.txt";
    private PrintWriter printer;
    
    public Logger() {
        try {
            printer = new PrintWriter(new FileWriter(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logException(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now()+ "\n\n");
        sb.append("Exception thrown: \n");
        sb.append(e.getMessage() + "\n");
        printer.println(sb);
        e.printStackTrace(printer);
        printer.println();
    }
}
