import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorsesRace
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService es = Executors.newFixedThreadPool(10);
        FinishingLineImp f = new FinishingLineImp();
        for (int i = 1; i <= 10; i++)
        {
            HorseImp horse = new HorseImp("h"+String.valueOf(i),f,10);
            es.execute(horse);
        }
        es.shutdown();
        es.awaitTermination(20, TimeUnit.SECONDS);
        f.print();
    }

}
