package se.kth.IV1350.integration;

import org.junit.*;
import static org.junit.Assert.*;

import se.kth.IV1350.dto.ItemDTO;

public class ExternalInventoryTest {
    ExternalInventory eis;

    @Before
    public void setUp() {
        eis = new ExternalInventory();
    }

    @After
    public void tearDown() {
        eis = null;
    }

    @Test
    public void testGetItem() {
        try {
            ItemDTO item = eis.getItem("1");
            assertTrue("Item was not retrieved", item != null);
        } catch (DatabaseUnreachableException | InvalidIDException e) {
            fail("Invalid item id or database unreachable error: " + e.getMessage());
        }
        
    }

    @Test
    public void testGetInvalidItem() {
        try {
            eis.getItem("10");
        } catch (InvalidIDException e) {
            assertTrue(true);
        } catch (DatabaseUnreachableException e) {
            fail(e.getMessage());
        }
        
    }

    @Test
    public void testCauseDatabaseUnreachableException() {
        try {
            ItemDTO item = eis.getItem("99");
            assertTrue("Database was reached but should not have been", item != null);
        } catch (DatabaseUnreachableException e) {
            assertTrue(true);
        } catch (InvalidIDException e) {
            fail(e.getMessage());
        }
    }
}