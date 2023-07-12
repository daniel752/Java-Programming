public class PrisonerDilemmas extends Game
{
    public PrisonerDilemmas(Player p1, Player p2)
    {
        super(p1, p2, "Prisoner's Dilemma");
        initActions();
    }
    protected void initActions()
    {
        actions = new Action[2];
        actions[0] = new Action("Testify"); //prisoner talks
        actions[1] = new Action("Silence"); //prisoner doesn't talk
    }
    protected void rewardPlayers(Action a1,Action a2) //a1 - first player action, a2 - second player action
    {
        if (a1.equals(actions[0]) && a2.equals(actions[0]))
        {
            getFirstPlayer().updateScore(5);
            getSecondPlayer().updateScore(5);


        } else if (a1.equals(actions[0]) && a2.equals(actions[1]))
        {
            getFirstPlayer().updateScore(0);
            getSecondPlayer().updateScore(15);

        } else if (a1.equals(actions[1]) && a2.equals(actions[0]))
        {
            getFirstPlayer().updateScore(15);
            getSecondPlayer().updateScore(0);

        } else if (a1.equals(actions[1]) && a2.equals(actions[1]))
        {
            getFirstPlayer().updateScore(1);
            getSecondPlayer().updateScore(1);

        }
    }
}