package se.kth.IV1350.integration;

/**
 * A class repsonsible for representing an exception for when an item id can not be found.
 */
public class InvalidIDException extends Exception {
    /**
     * Constructor for InvalidIDException.
     * @param msg a string containing the error information.
     */
    public InvalidIDException(String msg) {
        super(msg);
    }
}
