import java.util.ArrayList;

public class FinishingLine
{
    ArrayList<String> ranking = new ArrayList<String>(10);

    public FinishingLine(){};
    public synchronized void arrive(Horse h) throws InterruptedException
    {
        ranking.add(h.getId());
        Race.stopRace();
    }
    public void print()
    {
        for(String s : ranking)
            System.out.println("Horse: " + s + " at "+String.valueOf(ranking.indexOf(s)+1)+" position");
        System.out.println("=============================");
    }
}
