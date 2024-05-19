package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.IV1350.model.Observer;

public class TotalRevenueFileOutput implements Observer {
    private String path = "revenuelog.txt";
    private double total = 0;
    private PrintWriter printer;

    public TotalRevenueFileOutput() {
        try {
            printer = new PrintWriter(new FileWriter(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void totalRevenue(double amount) {
        total += amount;
        StringBuilder sb = new StringBuilder();
        sb.append("Total revenue: " + total);
        printer.println(sb);
        System.out.println("Printed");
    }
}
