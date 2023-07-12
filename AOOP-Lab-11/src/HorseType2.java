public class HorseType2 extends Horse
{

    public HorseType2(String id, FinishingLine f, int distance)
    {
        super(id, f, distance);
    }

    @Override
    public String toString()
    {
        return "HorseType2," +
                " id: " + id +
                ", distance: " + distance +";\n";
    }
}
