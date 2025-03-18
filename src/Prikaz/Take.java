package Prikaz;

public class Take extends Command {
    private Search search;
    private Inventory inventory;


    public Take(Search search, Inventory inventory) {
        this.search = search;
        this.inventory = inventory;

    }

    @Override
    public String execute() {
        return takeItem();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String takeItem() {
        Room currentRoom = search.getWorldMap().getWorld().get(search.getWorldMap().getCurrentPosition());
        int roomId = currentRoom.getId();

        String item = search.getRoomItem(roomId);

        if (item != null) {
            inventory.addItem(item);
            search.removeRoomItem(roomId);
            return "Sebral jsi předmět: " + item;
        }
        return "V této místnosti není žádný předmět k sebrání.";
    }
}