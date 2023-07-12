import java.util.ArrayList;
import java.util.Vector;

public class FinishingLineImp implements FinishingLine
{
    ArrayList<String> ranking = new ArrayList<String>(10);

    public FinishingLineImp(){}
    @Override
    public void arrive(Horse h)
    {
        ranking.add(h.getId());
    }
    public void print()
    {
        for(String s : ranking)
            System.out.println("Horse: "+s+" at "+String.valueOf(ranking.indexOf(s)+1)+" position");
    }
}
