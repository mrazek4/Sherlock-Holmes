package Prikaz;

import java.util.Scanner;

public class  SolveMystery extends Command {
Scanner sc = new Scanner(System.in);
private boolean solved = false;
    @Override
    public String execute() {
        System.out.println("Zadejte jmeno vraha");
        System.out.print(">> ");
        String userGuess = sc.nextLine().trim().toLowerCase();
        if (userGuess.equals("lady margaret")) {
            solved = true;
            return "Pripad vyresen!";
        }else {
            return "Spatna odpoved, pokracuj ve vysetrovani";
        }


    }

    @Override
    public boolean exit() {
        return solved;
    }
}
