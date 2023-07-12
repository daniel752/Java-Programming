import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer3
{
    Queue<Integer> workingQueue = new LinkedList<Integer>();

    public static void main(String[] args) throws InterruptedException
    {
        ProducerConsumer3 producerConsumer3 = new ProducerConsumer3();
        for (int i = 0; i < 10 ; i++)
            producerConsumer3.produce(i);

        producerConsumer3.consume();
        producerConsumer3.consume();
        producerConsumer3.consume();
        producerConsumer3.consume();
        producerConsumer3.consume();
    }
    public synchronized void produce(int num) throws InterruptedException
    {
        //checking if "workingQueue" has 10 elements, if it does will be put on "wait()"
        //otherwise adding element to "workingQueue"
        while (workingQueue.size() <= 10)
            wait();
        workingQueue.add(num);
        notifyAll();
    }
    public synchronized Integer consume() throws InterruptedException
    {
        while (workingQueue.isEmpty())
            wait();
        System.out.println("Product is consumed: " + this.workingQueue.element());
        return workingQueue.poll();
    }
}
