package Prikaz.Test;

import Prikaz.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void addItem() {
        Inventory inventory = new Inventory();
        String result = inventory.addItem("dýka");
        assertEquals("item byl pridan", result);
    }
    @Test
    void inventorySizeTest(){
        Inventory inventory = new Inventory();
        inventory.addItem("dyka");
        inventory.addItem("nuz");
        inventory.addItem("klic");

       String result = inventory.addItem("figurka");
       assertEquals("inventar je plny",result);

    }

    @Test
    void removeItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("klíč");
        String result = inventory.removeItem("klíč");
        assertEquals("item byl odebran", result);

    }
    @Test
    void testRemoveItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("dyka");
        String result = inventory.removeItem("klíč");
        assertEquals("tento item nemas", result);
    }

    @Test
    void hasItem() {
        Inventory inventory = new Inventory();
        inventory.addItem("klíč");
        assertTrue(inventory.hasItem("klíč"));
        assertFalse(inventory.hasItem("mec"));
    }
}