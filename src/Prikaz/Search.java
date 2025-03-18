package Prikaz;

import java.util.HashMap;
import java.util.Map;

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

    private void initializeItems() {
        roomItems.put(5, "Klíč");
        roomItems.put(7, "Šperk");
        roomItems.put(3, "Dýka");
        roomItems.put(4, "Dopis");
        roomItems.put(1, "Noviny");
    }

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
