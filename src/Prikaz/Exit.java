package Prikaz;

public class Exit extends Command {
    @Override
    public String execute() {
        return " Hra ukončena";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
