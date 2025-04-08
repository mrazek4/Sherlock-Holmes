package Prikaz;
/**
 * The Exit class represents a command to exit the game.
 */
public class Exit extends Command {
    @Override
    public String execute() {
        return "Hra ukončena";
    }

    @Override
    public boolean exit() {
        return true;

    }
}
