import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(4);

        // execution of Runnable by call of execute()
        for (int i = 0; i < 6; i++) {
            e.execute(new CountDown(i));
        }
        e.shutdown();
        Thread.sleep(1000);

        System.out.println("End of work");
    }
}
