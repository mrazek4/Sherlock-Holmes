package Prikaz;
/**
 * Class Take represents a command for taking items which user found.
 */
public class Take extends Command {
    private Search search;
    private Inventory inventory;


    public Take(Search search, Inventory inventory) {
        this.search = search;
        this.inventory = inventory;

    }
    /**
     * Executes the take command.
     *
     * @return A message indicating the result of taking an item.
     */
    @Override
    public String execute() {
        return takeItem();
    }

    @Override
    public boolean exit() {
        return false;
    }
    /**
     * Takes an item from the current room and adds it to inventory.
     *
     * @return A message indicating whether an item was taken.
     */
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