package se.kth.IV1350.integration;

/**
 * A class responsible for representing an exception for when the database can not be reached.
 */
public class DatabaseUnreachableException extends RuntimeException {
    /**
     * Constructor for DatabaseUnreachableException.
     */
    public DatabaseUnreachableException() {
        super("Database could not be reached.");
    }
}
