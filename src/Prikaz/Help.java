package Prikaz;

public class Help extends Command {
    @Override
    public String execute() {
        return "prikazy, ktere muzes pouzit: jdi, pomoc, konec, pouzit, mluv, prohledat, vzit, vyresit ";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
