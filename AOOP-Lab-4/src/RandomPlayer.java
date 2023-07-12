import java.util.Random;

public class RandomPlayer extends Player
{
    public RandomPlayer(String name)
    {
        super(name);
    }
    public Action selectAction(Action[] actions)
    {
        Random random = new Random();
        int random_index;
        if(actions[0].equals("Rock")) // if we're playing rock paper scissors
        {
            random_index = random.nextInt(3);
        }
        else // if we're playing prisoner dilemmas
        {
            random_index = random.nextInt(2);
        }
        return actions[random_index];
    }
}
