package Prikaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Movement class represents a command to move between rooms.
 */
public class Movement extends Command {

    @Override
    public String execute() {
        move();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    private WorldMap worldMap;
    private Scanner sc = new Scanner(System.in);
    private HashMap<Integer, String> postavyVMistnostech;

    public Movement(WorldMap worldMap, Scanner sc) {
        this.worldMap = worldMap;
        this.sc = sc;
        inicializujPostavy();

    }
    /**
     * Initializes characters present in different rooms.
     */
    private void inicializujPostavy() {
        postavyVMistnostech = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/postavy"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                int roomId = Integer.parseInt(parts[0]);
                String characterName = parts[1];
                postavyVMistnostech.put(roomId, characterName);
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání postav: " + e.getMessage());
        }

    }
    /**
     * Moves the player to a different room.
     */
    private void move() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        System.out.println("V momentální chvíli se nacházíš v: " + currentRoom.getLocationName() + " Můžeš jít do:");
        for (int roomID : currentRoom.getAvailableRooms()) {
            Room availableRoom = worldMap.getWorld().get(roomID);
            System.out.println(roomID + " - " + availableRoom.getLocationName());
        }
        System.out.println("Zadejte číslo místnosti");
        String input = sc.nextLine();
        if (!input.matches("\\d+")) {
            System.out.println("Neplatný vstup");
            return;
        }
        int targetRoomID = Integer.parseInt(input);
        if (!currentRoom.getAvailableRooms().contains(targetRoomID)) {
            System.out.println("Sem nemůžeš");
            return;
        }

        worldMap.setCurrentPosition(targetRoomID);
        System.out.println("Přesunul ses do:" + worldMap.getWorld().get(targetRoomID).getLocationName());
        String postavy = postavyVMistnostech.getOrDefault(targetRoomID, "nikdo tu neni");
        System.out.println("v mistnosti se nachazi: " +postavy);

    }

}
