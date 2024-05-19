package se.kth.IV1350.view;

import se.kth.IV1350.model.Observer;

public class TotalRevenueView implements Observer {
    private double total = 0;

    @Override
    public void totalRevenue(double amount) {
        total += amount;
        System.out.println("Total revenue: " + total);
    }
}
