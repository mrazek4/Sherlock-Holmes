package Prikaz;

import Prikaz.Konzole.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Class History represents a command for showing history of written commands
 */
public class History extends Command {
    /**
     * saving all commands to file
     * @return if something is wrong message will tell you
     */
    @Override
    public String execute() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/HistoriePrikazu"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            return list.toString();//prevedeni na text retezec
        } catch (Exception e) {
            return "Historie prikazu neni k dispozici";
        }


    }

    @Override
    public boolean exit() {

        return false;
    }

}
