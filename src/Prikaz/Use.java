package Prikaz;

public class Use extends Command {
    private Search search;
    private Inventory inventory;
    private WorldMap worldMap;
    private boolean cabinetUnlocked = false;

    public Use(Search search, Inventory inventory, WorldMap worldMap) {
        this.search = search;
        this.inventory = inventory;
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {
        return useItem();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String useItem() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        int roomId = currentRoom.getId();

        if (inventory.hasItem("Klíč") && roomId == 3) {
            if (!cabinetUnlocked) {
                cabinetUnlocked = true;
                inventory.removeItem("Klíč");
                inventory.addItem("Tajný dokument");
                return "Použil jsi klíč k odemknutí skříňky v pracovně! Uvnitř jsi našel Tajný dokument.";
            } else {
                return "Skříňka už je odemčená.";
            }
        } else if (roomId == 3) {
            return "Skříňka je zamčená. Možná potřebuješ klíč?";
        } else {
            return "Tady teď nemůžeš nic použít.";
        }
    }
}