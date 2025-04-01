package Prikaz;

/**
 * The Command class represents an abstract command with execution behavior.
 */
public abstract class Command {
    /**
     * Executes the command and returns a response.
     *
     * @return Response of the command execution.
     */
    public abstract String execute();

    /**
     * Determines if the command results in exiting the game.
     *
     * @return true if the game should exit, false otherwise.
     */
    public abstract boolean exit();
}
