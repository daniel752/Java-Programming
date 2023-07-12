public class HorseType3 extends Horse
{

    public HorseType3(String id, FinishingLine f, int distance)
    {
        super(id, f, distance);
    }

    @Override
    public String toString()
    {
        return "HorseType3," +
                " id: " + id +
                ", distance: " + distance +";\n";
    }
}
