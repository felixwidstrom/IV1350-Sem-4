package se.kth.IV1350.view;

import se.kth.IV1350.model.Observer;

/**
 * A class responsible for keeping track of the total revenue and displaying it to the user.
 */
public class TotalRevenueView implements Observer {
    /**
     * Variable declarations.
     */
    private double total = 0;

    /**
     * An implementation for the totalRevenue method derived from the observer interface responsible for displaying the total revenue to the user.
     * @param amount a double representing an amount to be added to the total.
     */
    @Override
    public void totalRevenue(double amount) {
        total += amount;
        System.out.println("Total revenue: " + total);
    }
}
