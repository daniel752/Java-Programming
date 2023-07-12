import java.util.Scanner;

public abstract class Game
{
    private Player p1, p2;
    private String name; //game name
    protected Action[] actions; // the set of actions
    public Game(Player p1, Player p2, String name)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.name = new String(name);
    }
    protected abstract void initActions();
    public void play(int turnCount)
    {
        while(turnCount > 0)
        {
            playSingleTurn();
            turnCount--;
        }
    }
    private void playSingleTurn()
    {
        this.initActions();
        Action p1_act,p2_act;
        p1_act = p1.selectAction(actions);
        p2_act = p2.selectAction(actions);
        rewardPlayers(p1_act,p2_act);
        System.out.println("User's choice: " + p1_act.getName());
        System.out.println("AI's choice: " + p2_act.getName());
        System.out.println("The winner is: " + getWinner().getName());
        System.out.println();
    }
    // There is no real scoring strategy in a general game
    protected abstract void rewardPlayers(Action a1,Action a2);
    public Player getWinner ()
    {
        if((p1.isWinner(p2))&&(p2.isWinner(p1)))
            return new ConsecutivePlayer(p1.getName()+" and "+p2.getName());
        else if(p1.isWinner(p2))
            return p1;
        else if(p2.isWinner(p1))
            return p2;
        return new ConsecutivePlayer("Nobody");
    }
    protected Player getFirstPlayer()
    {
        return this.p1;
    }
    protected Player getSecondPlayer()
    {
        return this.p2;
    }
}
