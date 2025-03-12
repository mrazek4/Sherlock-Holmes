package Prikaz;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<String> items = new ArrayList<>();

    public String addItem(String item) {
        if (items.size() <= 3) {
            items.add(item);
            return "item byl pridan";

        }
        return "inventar je plny";
    }

    public String removeItem(String item) {
        items.remove(item);
        return "item byl odebran";
    }

    public boolean hasItem(String item) {
        return false;
    }

    public String showInventory() {
        return items.toString();

    }

    @Override
    public String toString() {
        return "Inventory" +
                "items=" + items +
                '}';
    }
}
