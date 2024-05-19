package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.IV1350.model.Observer;

/**
 * A class responsible for keeping track of the total revenue and printing it to a file.
 */
public class TotalRevenueFileOutput implements Observer {
    /**
     * Object and variable declarations.
     */
    private String path = "revenuelog.txt";
    private double total = 0;
    private PrintWriter printer;

    /**
     * Constructor for TotalRevenueFileOutput.
     */
    public TotalRevenueFileOutput() {
        try {
            printer = new PrintWriter(new FileWriter(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * An implementation for the totalRevenue method derived from the observer interface responsible for writing the total revenue to a file.
     * @param amount a double representing an amount to be added to the total.
     */
    @Override
    public void totalRevenue(double amount) {
        total += amount;
        StringBuilder sb = new StringBuilder();
        sb.append("Total revenue: " + total);
        printer.println(sb);
    }
}
