
public class HorseImp implements Runnable,Horse
{
    String id;
    FinishingLine f;
    int distance;

    public HorseImp(String id, FinishingLine f, int distance)
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
            for(int i=getDistance();i>=0;i--)
            {
                System.out.println(getID()+" distance: " + i);
                Thread.sleep(((int) (Math.random() * 1000)));
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Something has gone wrong");
        }
        arrive(this);
        f.arrive(this);
    }
    @Override
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
