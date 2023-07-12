public class HorseType1 extends Horse
{

    public HorseType1(String id, FinishingLine f, int distance)
    {
        super(id, f, distance);
    }

    @Override
    public String toString()
    {
        return "HorseType1," +
                " id: " + id +
                ", distance: " + distance +";\n";
    }
}
