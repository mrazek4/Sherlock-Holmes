public class Location {
    private String name;
    private int ID;
    private int[] locations;

    public Location(String name, int ID, String[] locations) {
        this.name = name;
        this.ID = ID;
        this.locations = new int[6];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
    }
}
