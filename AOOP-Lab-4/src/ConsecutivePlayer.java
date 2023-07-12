import java.util.Scanner;

public class ConsecutivePlayer extends Player
{
    private int lastIdx;
    public ConsecutivePlayer(String name)
    {
        super(name);
        lastIdx = 0;
    }
    public Action selectAction(Action[] actions)
    {
        Scanner input = new Scanner(System.in);
        if(actions[0].getName() == "Rock") // if we're playing rock paper scissors
        {
            System.out.println("Consecutive player's options:");
            System.out.println("Rock - 1,Paper - 2,Scissors - 3");
            System.out.println("Enter your action:");
            lastIdx = input.nextInt();
        }
        else // if we're playing prisoner dilemmas
        {
            System.out.println("Consecutive player's options:");
            System.out.println("Testify - 1,Silence - 2");
            System.out.println("Enter your action:");
            lastIdx = input.nextInt();
        }
        return actions[--lastIdx];
    }
}
