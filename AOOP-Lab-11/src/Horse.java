import java.util.Random;

public class Horse implements Runnable
{
    String id;
    FinishingLine f;
    int distance;
    Random random = new Random();

    public Horse(String id, FinishingLine f, int distance)
    {
        setId(id);
        setF(f);
        setDistance(distance);
        System.out.println("new Horse: " + id);
    }
    @Override
    public void run()
    {
        try
        {
            for(int i=100;i>0;)
            {
                i -= random.nextInt(10);
                if(i <= 1)
                    i = 0;
                setDistance(i);
                if(i > 0)
                {
                    System.out.println(getID() + " distance: " + i);
                    Thread.sleep(200);
                }
            }
            synchronized (Race.getHorses())
            {
                arrive(this);
                f.arrive(this);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(getID() + " didn't make it to the finishing line");
        }
    }
    public String getId()
    {
        return id;
    }
    public void arrive(Horse h)
    {
        System.out.println(getID() + " has crossed the finish line!");
    }
    public String getID()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public FinishingLine getF()
    {
        return f;
    }
    public void setF(FinishingLine f)
    {
        this.f = f;
    }
    public int getDistance()
    {
        return distance;
    }
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    public FinishingLine getFinishingLine(){return this.f;}
}
