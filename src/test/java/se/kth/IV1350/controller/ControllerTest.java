package se.kth.IV1350.controller;

import org.junit.*;
import static org.junit.Assert.*;

import se.kth.IV1350.dto.ItemDTO;
import se.kth.IV1350.integration.DatabaseUnreachableException;
import se.kth.IV1350.integration.DiscountDB;
import se.kth.IV1350.integration.ExternalAccounting;
import se.kth.IV1350.integration.ExternalInventory;
import se.kth.IV1350.integration.InvalidIDException;
import se.kth.IV1350.integration.Printer;

public class ControllerTest {
    Controller con;

    @Before
    public void setUp() {
        con = new Controller(new ExternalInventory(), new ExternalAccounting(), new DiscountDB(), new Printer());
        con.startSale();
    }

    @After
    public void tearDown() {
        con = null;
    }

    @Test
    public void testStartSale() {
        assertTrue("Controller or Receipt not initialized", con.sale != null && con.receipt != null);
    }

    @Test
    public void testScanItem() {
        try {
            ItemDTO item = con.scanItem("1", 1);
            assertTrue("Item not scanned correctly", item != null);
        } catch (InvalidIDException | DatabaseUnreachableException e) {
            fail("Invalid item id or database unreachable error: " + e.getMessage());
        }
        
    }

    @Test
    public void testScanInvalidItem() {
        try {
            ItemDTO item = con.scanItem("10", 1);
        } catch (InvalidIDException e) {
            assertTrue(true);
        } catch (DatabaseUnreachableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testStartDiscount() {
        double discount = con.startDiscount("felix");
        assertTrue("Discount not found", discount > 0);
    }

    @Test
    public void testInvalidCustomerIdDiscount() {
        double discount = con.startDiscount("test");
        assertTrue("Discount was applied but should not have been", discount == 0);
    }

    @Test
    public void testEndSale() {
        String r = con.endSale(100);
        assertTrue("Receipt incomplete, sale not ended correctly", 
            r.equals(
                "\nReceipt:\nTime of sale: " + con.sale.getSaleTime().toLocalDate() + " " + con.sale.getSaleTime().toLocalTime() + "\n\n" +
                "\nTotal: 0.0\n" + "Discount: 0.0\n" + "VAT: 0.0\n\n" + "Payment: 100.0\n" + "Change: 100.0"
            )
        );
    }

    @Test
    public void testPaymentSetOnEndSale() {
        con.endSale(100);
        assertTrue("Payment not set", con.sale.getPaymentAmount() == 100);
    }
}
