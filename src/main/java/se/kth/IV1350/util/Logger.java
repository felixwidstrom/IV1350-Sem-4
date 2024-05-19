package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * A class responsible for providing functionality for writing to a file.
 */
public class Logger {
    /**
     * Object and varaible declarations.
     */
    private String path = "log.txt";
    private PrintWriter printer;
    
    /**
     * Constructor for Logger.
     */
    public Logger() {
        try {
            printer = new PrintWriter(new FileWriter(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for writing an exception to a file.
     * @param e an excpetion to be logged.
     */
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
