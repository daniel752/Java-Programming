import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Race
{
    private static Race race;
    private static ArrayList<Horse> horses = new ArrayList<>();
    private static ArrayList<Horse> sortedHorses = new ArrayList<>();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static FinishingLine f = new FinishingLine();
    private Race() throws InterruptedException
    {
        Random random = new Random();
        int choice;
        for(int i=0;i<10;i++)
        {
            choice = random.nextInt(4);
            if(choice == 0)
                choice++;
            if(choice == 1)
                getHorses().add(new HorseType1("H-"+i,f,10));
            else if(choice == 2)
                getHorses().add(new HorseType2("H-"+i,f,10));
            else if(choice == 3)
                getHorses().add(new HorseType3("H-"+i,f,10));
        }
        //ExecutorService es = Executors.newFixedThreadPool(10);
        //FinishingLine f = new FinishingLine();
        horses.forEach(horse -> es.execute(horse));
        Thread.sleep(500);
        sortHorseRank();
        raceRanking();
    }
    public static void stopRace() throws InterruptedException
    {
        //getEs().awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("==========Race stopped==========");
        getEs().shutdownNow();
        f.print();
    }
    public static void raceRanking()
    {
        for(int i=0;i<3;i++)
            System.out.println("Horse index: " + i +"\n" + "HorseType: " + sortedHorses.get(i).toString());
    }
    public static void addHorse()
    {

    }
    public void sortHorseRank()
    {
        ArrayList<Horse> tempHorses = new ArrayList<>();
        Horse tempHorse;
        for(int i=0;i<getHorses().size();i++)
        {
            tempHorse = getHorses().get(i);
            for(int j=i+1;j<getHorses().size();j++)
            {
                if(tempHorse.getDistance() > getHorses().get(j).getDistance())
                {
                    tempHorse = getHorses().get(j);

                }
            }
            //getHorses().remove(tempHorse);
            tempHorses.add(tempHorse);
        }
        setSortedHorses(tempHorses);
    }
    public static ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses)
    {
        Race.horses = new ArrayList<>(horses);
    }

    public static ExecutorService getEs()
    {
        return es;
    }

    public static FinishingLine getF()
    {
        return f;
    }

    public static Race getRace() throws InterruptedException
    {
        if(race == null)
            race = new Race();
        return race;
    }

    public static ArrayList<Horse> getSortedHorses()
    {
        return sortedHorses;
    }

    public static void setSortedHorses(ArrayList<Horse> sortedHorses)
    {
        Race.sortedHorses = sortedHorses;
    }
}
