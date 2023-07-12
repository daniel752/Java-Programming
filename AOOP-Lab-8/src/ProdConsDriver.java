import java.util.concurrent.ArrayBlockingQueue;

public class ProdConsDriver {
    public static void main(String[] args) {
        final int BOUND = 5;
        final int AMOUNT = 10;
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(BOUND);
        Producer p1 = new Producer(1, AMOUNT, q);
        Producer p2 = new Producer(2, AMOUNT, q);
        Consumer c = new Consumer(3, 2 * AMOUNT, q);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c).start();
    }
}

class Producer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;
    private final int id;
    private final int amount; //Number of products to produce
    private final int PERIOD = 700;

    public Producer(int id, int amount, ArrayBlockingQueue<Integer> q) {
        this.id = id;
        this.amount = amount;
        queue = q;
    }

    public void run() {
        try {
            for (int i = 0; i < amount; i++) {
                //Time period required for producing one product
                Thread.sleep(PERIOD);
                queue.put(produce(id, i));
            }
        } catch (InterruptedException ignored) {
        }
    }

    private int produce(int id, int iteration) {
        int product = id * amount + iteration;
        System.out.println("Producing: " + product);
        return product;
    }
}

class Consumer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;
    private final int amount; //Number of products to consume
    private final int id;
    private final int PERIOD = 2000;

    public Consumer(int id, int amount, ArrayBlockingQueue<Integer> q) {
        this.id = id;
        this.amount = amount;
        queue = q;
    }

    public void run() {
        try {
            for (int i = 0; i < amount; i++) {
                //Time period for consuming one product
                Thread.sleep(PERIOD);
                consume(queue.take());
            }
        } catch (InterruptedException ignored) {}
    }

    private void consume(Integer prod) {
        System.out.println("Consuming: " + prod); //consume an Integer product
    }
}