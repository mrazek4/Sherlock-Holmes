package Prikaz;

import java.util.Scanner;
/**
 * Class solveMystery represents a command for ending the game and guessing the right murderer.
 */
public class SolveMystery extends Command {
    Scanner sc = new Scanner(System.in);
    private boolean solved = false;
    /**
     * Executes the mystery-solving command.
     *
     * @return A message indicating whether the mystery was solved.
     */
    @Override
    public String execute() {
        System.out.println("Zadejte jmeno vraha");
        System.out.print(">> ");
        String userGuess = sc.nextLine().trim().toLowerCase();
        if (userGuess.equals("lady margaret")) {
            solved = true;
            return "Pripad vyresen!";
        } else {
            return "Spatna odpoved, pokracuj ve vysetrovani";
        }


    }
    /**
     * Determines whether solving the mystery exits the game.
     *
     * @return true if the mystery is solved, false otherwise.
     */
    @Override
    public boolean exit() {
        return solved;
    }
}
