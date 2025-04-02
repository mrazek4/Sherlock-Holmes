package Prikaz.Konzole;

import Prikaz.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Console class represents the game console where commands are processed.
 * It initializes the game, manages user input, and executes commands.
 */
public class Console {
    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy = new HashMap<>();
    private ArrayList<String> commands = new ArrayList<>();

    /**
     * Executes the user command entered to the console.
     */
    private void provedPrikaz() {

        System.out.print(">> ");
        String prikaz = scanner.nextLine();
        commands.add(prikaz);
        try (FileWriter fw = new FileWriter("src/HistoriePrikazu", true)){
                fw.write(prikaz + "\n");


        } catch (IOException e) {
            System.out.println("Chyba při ukládání příkazu: " + e.getMessage());
        }
        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Neplatný příkaz, zkus to znovu.");
        }
    }

    /**
     * Starts the console and continuously processes user commands until exit.
     */
    public void start() {
        inicializace();
        do {
            provedPrikaz();
        } while (!exit);
    }

    /**
     * Initializes game components and registers available commands.
     */
    private void inicializace() {
        WorldMap worldMap = new WorldMap();
        Inventory inventory = new Inventory();
        Search search = new Search(worldMap);

        worldMap.loadMap();
        prikazy.put("jdi", new Movement(worldMap, scanner));
        prikazy.put("konec", new Exit());
        prikazy.put("pomoc", new Help());
        prikazy.put("prohledat", new Search(worldMap));
        prikazy.put("vzit", new Take(search, inventory));
        prikazy.put("mluv", new Talk(worldMap));
        prikazy.put("pouzit", new Use(search, inventory, worldMap));
        prikazy.put("vyresit", new SolveMystery());
        prikazy.put("history", new History());

    }
}
