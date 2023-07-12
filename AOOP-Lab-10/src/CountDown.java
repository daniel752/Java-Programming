public class CountDown implements Runnable {
    private final int id;

    public CountDown(int num) {
        id = num;
    }

    @Override
    public void run() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("Task " + id + ", count: " + i);
            // thread passes from state "Running" to state "Ready" by call of yield() function:
            Thread.yield();
        }
    }
}
