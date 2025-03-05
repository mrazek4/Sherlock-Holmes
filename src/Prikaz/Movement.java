package Prikaz;
import java.util.Scanner;


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
    private Scanner sc;

    public Movement(WorldMap worldMap, Scanner sc) {
        this.worldMap = worldMap;
        this.sc = sc;
    }

    private void move() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        System.out.println("V momentální chvíli se nacházíš v: " + currentRoom.getLocationName() + "Můžeš jít do:");
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
    }
}
