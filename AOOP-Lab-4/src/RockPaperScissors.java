public class RockPaperScissors extends Game
{
    public RockPaperScissors(Player p1, Player p2)
    {
        super(p1, p2, "Rock Paper Scissors");
        initActions();
    }
    protected void initActions()
    {
        actions = new Action[3];
        actions[0] = new Action("Rock");
        actions[1] = new Action("Paper");
        actions[2] = new Action("Scissors");
    }
    protected void rewardPlayers(Action a1, Action a2)
    {
        //Draw between 2 actions so no change of score
        if((a1.equals(actions[0])&&a2.equals(actions[0]))||(a1.equals(actions[1])&&a2.equals(actions[1]))
                ||(a1.equals(actions[2])&&a2.equals(actions[2])));
        //Player 2 action wins
        else if((a1.equals(actions[0]))&&(a2.equals(actions[1]))||((a1.equals(actions[1]))&&(a2.equals(actions[2])))
                ||((a1.equals(actions[2]))&&(a2.equals(actions[0]))))
        {
            getFirstPlayer().updateScore(-1);
            getSecondPlayer().updateScore(1);
        }
        //Player 1 action wins
        else if((a1.equals(actions[1])&&a2.equals(actions[0]))||(a1.equals(actions[2])&&a2.equals(actions[1]))
                ||(a1.equals(actions[0])&&a2.equals(actions[2])))
        {
            getFirstPlayer().updateScore(1);
            getSecondPlayer().updateScore(-1);
        }
    }
}
