package se.kth.IV1350.model;

/**
 * An interface for defining the observer pattern to be used.
 */
public interface Observer {
    /**
     * A method for handling the observed events.
     * @param amount a double representing the amount to be added to the total.
     */
    void totalRevenue(double amount);
}
