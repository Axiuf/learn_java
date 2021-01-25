package com.atguigu.java2;

/**
 * 分析：是否多线程的问题，是，生产者线程，消费者线程
 * 是否共享数据，是，店员（或者产品）
 * 如何解决线程安全的问题，同步机制，三种方法
 * 是否设计到线程的通信，是
 *
 * @author axiuf
 * @create 2020/12/16-10:21
 */
class Clerk
{
    private int productCount = 0;

    // 生产产品
    public synchronized void produceProduct()
    {
        if (productCount < 20)
        {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");

            notify();
        }
        else
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    // 消费产品
    public synchronized void consumeProduct()
    {
        if (productCount > 0)
        {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }
        else
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread
{
    private Clerk clerk;

    public Producer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(getName() + "：开始生产产品。。。");

        while (true)
        {
            try
            {
                Thread.sleep(50);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Customer extends Thread
{
    private Clerk clerk;

    public Customer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(getName() + "：消费者开始消费产品。。。");

        while (true)
        {

            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }


    }
}

public class ProductTest
{
    public static void main(String[] args)
    {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者");

        Customer c1 = new Customer(clerk);
        c1.setName("消费者1");
        Customer c2 = new Customer(clerk);
        c2.setName("消费者2");


        p1.start();
        c1.start();
        c2.start();
    }
}