package Prikaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Class search represents a command for searching in rooms for items.
 */
public class Search extends Command {
    private WorldMap worldMap;
    private Map<Integer, String> roomItems;

    public Search(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.roomItems = new HashMap<>();
        initializeItems();
    }

    @Override
    public String execute() {
        return searchRoom();
    }

    @Override
    public boolean exit() {
        return false;
    }
    /**
     * Initializes the items found in specific rooms.
     */
    private void initializeItems() {

            roomItems = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/itemy"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("-");
                    int roomId = Integer.parseInt(parts[0]);
                    String item = parts[1];
                    roomItems.put(roomId, item);
                }
            } catch (IOException e) {
                System.out.println("Chyba při načítání předmětů: " + e.getMessage());
            }
        }
    /**
     * Searches the current room for items.
     *
     * @return A message indicating if an item is found.
     */
    public String searchRoom() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        String item = roomItems.get(currentRoom.getId());

        if (item != null) {
            return "V této místnosti se nachází: " + item;
        }
        return "V této místnosti se žádný předmět nenachází.";
    }
    public String getRoomItem(int roomId) {
        return roomItems.get(roomId);
    }

    public void removeRoomItem(int roomId) {
        roomItems.remove(roomId);
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }
}
