package Prikaz;

import java.io.BufferedReader;
import java.io.FileReader;
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

public Talk(WorldMap worldMap){
    this.worldMap = worldMap;
    initializeCharacters();
}
    /**
     * Initializes NPCs in rooms.
     */
    private void initializeCharacters() {
        characters = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/char"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                int roomId = Integer.parseInt(parts[0]);
                String character = parts[1];
                characters.put(roomId, character);
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání postav: " + e.getMessage());
        }
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