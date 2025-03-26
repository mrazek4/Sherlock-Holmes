package Prikaz;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<String> items = new ArrayList<>();

    public String addItem(String item) {
        if (items.size() <= 2) {
            items.add(item);
            return "item byl pridan";

        }
        return "inventar je plny";
    }

    public String removeItem(String item) {
        if (items.contains(item)) {
        items.remove(item);
        return "item byl odebran";
    }
    return "tento item nemas";
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }




}
