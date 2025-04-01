package Prikaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * The WorldMap class represents the game's map structure.
 * It is responsible for loading the map from a file, managing rooms, and tracking the player's position.
 */
public class WorldMap {
    private HashMap<Integer, Room> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;
    /**
     * Loads the map from the "src/mapa.txt" file.
     * Each line in the file represents a room, containing its ID, name, and accessible neighboring rooms.
     *
     * @return true if the map was loaded successfully,  false otherwise.
     */
    public boolean loadMap() {


        try (BufferedReader br = new BufferedReader(new FileReader("src/mapa.txt"))) {
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter == 1) {
                    continue;

                }
                String[] data = line.split("-");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                ArrayList<Integer> availableRooms = new ArrayList<>();
                if (data.length > 2 && !data[2].trim().isEmpty()) {
                    String[] rooms = data[2].trim().split(",");
                    for (String room : rooms) {
                        availableRooms.add(Integer.parseInt(room));
                    }
                }
                Room room = new Room(id, name, availableRooms);
                world.put(id, room);
            }


            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }


    public HashMap<Integer, Room> getWorld() {
        return world;
    }

    public void setWorld(HashMap<Integer, Room> world) {
        this.world = world;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}


