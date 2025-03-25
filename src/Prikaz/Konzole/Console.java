package Prikaz.Konzole;

import Prikaz.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy = new HashMap<>();
    private ArrayList<String> commands = new ArrayList<>();

    private void provedPrikaz() {
        System.out.print(">> ");
        String prikaz = scanner.nextLine();
        commands.add(prikaz);

        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Neplatný příkaz.");
        }
    }

    public void start() {
        inicializace();
        do {
            provedPrikaz();
        } while (!exit);
    }

    private void inicializace() {
        WorldMap worldMap = new WorldMap();
        Inventory inventory = new Inventory();
        Search search = new Search(worldMap);

        worldMap.loadMap();
        prikazy.put("jdi", new Movement(worldMap, scanner));
        prikazy.put("konec", new Exit());
        prikazy.put("pomoc", new Help());
        prikazy.put("prohledat",new Search(worldMap));
        prikazy.put("vzit", new Take(search,inventory));
        prikazy.put("mluv", new Talk(worldMap));
        prikazy.put("pouzit", new Use(search, inventory, worldMap));
        prikazy.put("vyresit", new SolveMystery());

    }
}
