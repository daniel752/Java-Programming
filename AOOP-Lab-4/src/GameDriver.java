import java.util.Scanner;

public class GameDriver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome!!!");
        System.out.println("Game Menu:");
        System.out.println("1.RockPaperScissors\n2.PrisonerDilemmas");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        int rounds;
        Player p1 = new ConsecutivePlayer("Daniel"); // user's player
        Player p2 = new RandomPlayer("AI"); // AI's player
        switch (choice)
        {
            case 1:
                System.out.println("How many rounds would you like to play?");
                rounds = input.nextInt();
                Game rps = new RockPaperScissors(p1,p2);
                rps.play(rounds);
                break;

            case 2:
                System.out.println("How many rounds would you like to play?");
                rounds = input.nextInt();
                Game pd = new PrisonerDilemmas(p1,p2);
                pd.play(rounds);
                break;
        }


        /*
        Player p1 = new ConsecutivePlayer("Daniel");
        Player p2 = new RandomPlayer("Yossi");
        //Game rps = new RockPaperScissors(p1,p2);
        //rps.play(2);

        Game pd = new PrisonerDilemmas(p1,p2);
        pd.play(2);
         */
    }
}
