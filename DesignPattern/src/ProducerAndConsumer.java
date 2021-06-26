import java.util.LinkedList;


/**
 * @author Shan Cheng
 * @since 2021/4/12
 */
public class ProducerAndConsumer
{
    public static void main(String[] args)
    {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);
        Producer producer = new Producer(myBlockingQueue);
        Consumer consumer = new Consumer(myBlockingQueue);
        new Thread(consumer, "T2").start();
        new Thread(producer, "T1").start();
    }
}

class MyBlockingQueue
{
    private int maxSize;
    private LinkedList<Object> storage;

    public MyBlockingQueue(int maxSize)
    {
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    public synchronized void put() throws InterruptedException
    {
        while (storage.size() == maxSize) wait();

        storage.add(new Object());
        System.out.println("put, storage is " + storage.size());
        // Thread.sleep(100);

        notifyAll();
    }

    public synchronized void take() throws InterruptedException
    {
        while (storage.size() == 0) wait();

        storage.remove();
        System.out.println("get, storage is " + storage.size());
        Thread.sleep(100);

        notifyAll();
    }
}

class Consumer implements Runnable
{
    private MyBlockingQueue storage;

    public Consumer(MyBlockingQueue storage)
    {
        this.storage = storage;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                storage.take();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable
{
    private MyBlockingQueue storage;

    public Producer(MyBlockingQueue storage)
    {
        this.storage = storage;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                storage.put();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}