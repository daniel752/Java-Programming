import java.io.File;
import java.util.Scanner;

public class TennisDriver {
    final static String file_name = "src\\data.dat";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to restart ranking (y/n)?");
        String input = in.next();
        if (input.equals("y") || input.equals("Y"))
            new File(file_name).delete();
        in.close();

        String[] names = {"Australian Open", "French Open", "Wimbledon", "USA Open", "ATP final"};
        for (String name : names) {
            Tournament t = new Tournament(name, file_name);
            t.simulateTournament();
            t.printPlayers();
        }
    }

}