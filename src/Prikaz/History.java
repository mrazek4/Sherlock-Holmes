package Prikaz;

import Prikaz.Konzole.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class History extends Command {
    @Override
    public String execute() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/HistoriePrikazu"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            return list.toString();
        } catch (Exception e) {
            return "Historie prikazu neni k dispozici";
        }


    }

    @Override
    public boolean exit() {
        return false;
    }
}
