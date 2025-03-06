public class Characters {
    private String name;
    private int progress; //Kolikaty text hraci vypsat

    public String speak() {
        return " ";
    }

    public String getText(){
        progress++;
        return "res/" + name + ".txt";
    }
}
