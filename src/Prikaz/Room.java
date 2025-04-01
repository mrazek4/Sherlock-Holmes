package Prikaz;

import java.util.ArrayList;
/**
 * Represents a rooms in the game world.
 */
public class Room {
private int id;
private String locationName;
private ArrayList<Integer>availableRooms;

    public Room(int id, String locationName, ArrayList<Integer> availableRooms) {
        this.id = id;
        this.locationName = locationName;
        this.availableRooms = availableRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public ArrayList<Integer> getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(ArrayList<Integer> availableRooms) {
        this.availableRooms = availableRooms;
    }

    @Override
    public String toString() {
        return "Prikaz.Room " +
                "id " + id +
                " locationName" + locationName +
                " availableRooms=" + availableRooms ;

    }
}
