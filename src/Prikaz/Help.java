package Prikaz;
/**
 * The Help class provides a list of available commands in the game.
 */
public class Help extends Command {
    @Override
    public String execute() {
        return "prikazy, ktere muzes pouzit: jdi, pomoc, konec, pouzit, mluv, prohledat, vzit, vyresit, historie ";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
