package Prikaz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Talk extends Command {
    private WorldMap worldMap;
    private Map<Integer, String> characters; // Mapa pro přiřazení postav k místnostem

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

    public String talkToPerson() {
        Room currentRoom = worldMap.getWorld().get(worldMap.getCurrentPosition());
        String character = characters.get(currentRoom.getId());

        if (character != null) {
            return loadDialogue(character);
        }
        return "Tady není nikdo, s kým bys mohl mluvit.";
    }

    private String loadDialogue(String character) {
        String filePath = "dialogy/" + character + ".txt";

        try {
            return new String(Files.readAllBytes(Paths.get(filePath))); //delano pres chatGPT
        } catch (IOException e) {
            return "Nenalezen soubor pro dialog " + character + ".";
        }
    }
}