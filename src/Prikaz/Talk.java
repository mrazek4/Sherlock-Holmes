package Prikaz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
/**
 * Class Talk represents a command for talking with NPCs and initializes NPCs in the rooms.
 */
public class Talk extends Command {
    private WorldMap worldMap;
    private Map<Integer, String> characters;

    /**
     * Initializes NPCs in rooms.
     */

    public Talk(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.characters = new HashMap<>();
        characters.put(1, "Watson");
        characters.put(2, "Zahradnik");
        characters.put(3, "Komornik James");
        characters.put(5, "Tom");
        characters.put(6, "Sluzebnictvo");
        characters.put(7, "Lady Margaret");
    }

    @Override
    public String execute() {
        return talkToPerson();
    }

    @Override
    public boolean exit() {
        return false;
    }
    /**
     * Handles the interaction with the NPC in the player's current room.
     * It retrieves the NPC associated with the current room and loads their dialogue.
     *
     * @return The dialogue of the NPC in the current room, or a message indicating no NPC is present.
     */
    public String talkToPerson() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        String character = characters.get(currentRoom.getId());

        if (character != null) {
            return loadDialogue(character);
        }
        return "Tady není nikdo, s kým bys mohl mluvit.";
    }
    /**
     * Loads the dialogue for the specified NPC by reading from a text file.
     * The file is expected to be located in the "res/dialogy/" directory, named according to the NPC's name.
     *
     * @param character The name of the NPC whose dialogue is to be loaded.
     * @return The content of the dialogue file, or an error message if the file cannot be found.
     */
    private String loadDialogue(String character) {
        String filePath = "res/dialogy/dialog." + character + ".txt";

        try {
            return new String(Files.readAllBytes(Paths.get(filePath))); //delano pres chatGPT
        } catch (IOException e) {
            return "Nenalezen soubor pro dialog " + character ;
        }
    }
}