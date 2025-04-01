package Prikaz;

import java.util.ArrayList;

/**
 * The Inventory class represents a player's inventory with limited capacity.
 */
public class Inventory {
    private ArrayList<String> items = new ArrayList<>();

    /**
     * Adds an item to the inventory if there is space.
     *
     * @param item The item to be added.
     * @return Message indicating success or failure.
     */
    public String addItem(String item) {
        if (items.size() <= 2) {
            items.add(item);
            return "item byl pridan";

        }
        return "inventar je plny";
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item The item to be removed.
     * @return Message indicating success or failure.
     */
    public String removeItem(String item) {
        if (items.contains(item)) {
            items.remove(item);
            return "item byl odebran";
        }
        return "tento item nemas";
    }

    /**
     * Checks if an item is in the inventory.
     *
     * @param item The item to check.
     * @return true if the item is in the inventory, false otherwise.
     */
    public boolean hasItem(String item) {
        return items.contains(item);
    }


}
