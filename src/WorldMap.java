
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class WorldMap {
private HashMap<Integer, Location>world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;

    public boolean loadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 1, 7)
                );
                world.put(Integer.valueOf(lines[0]), location);
            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    public Location getCurrentPosition(){
        return world.get(currentPosition);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }
}


