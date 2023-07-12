public abstract class Player
{
    private String name;
    private int score;
    public Player(String name)
    {
        this.name = name;
        this.score = 0;
    }
    public abstract Action selectAction(Action[] actions);

    //method to check if 'this' player is winner over 'other' 'Player p'
    public boolean isWinner(Player p)
    {
        if((0 <= score && score <= 15)&&(0 <= p.getScore() && p.getScore() <= 15))
            return (score < p.getScore())||(score == 1 && p.getScore() == 1);
        else if((-1 <= score && score <=1)&&(-1 <= p.getScore() && p.getScore() <=1))
            return score > p.getScore();
        return false;
    }
    public void updateScore(int score)
    {
        this.score = score;
    }
    public int getScore() { return this.score; }
    public String getName() { return this.name; }
}
