package se.kth.IV1350.integration;

public class DatabaseUnreachableException extends RuntimeException {
    public DatabaseUnreachableException() {
        super("Database could not be reached.");
    }
}
