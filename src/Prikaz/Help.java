package Prikaz;

public class Help extends Command {
    @Override
    public String execute() {
        return "jdi, pomoc, konec, pouzit, mluv, prohledat, vzit ";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
