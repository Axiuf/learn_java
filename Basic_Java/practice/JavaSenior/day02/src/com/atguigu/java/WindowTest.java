package com.atguigu.java;

/**
 * 方式一：同步代码块
 * synchronized (监视器）
 * {
 *     // 需要被同步的代码块
 * }
 * 说明：同步代码块，操作需要同步的变量的代码块，————>不能包多了也不能包的太少
 * 同步变量：需要保持同步的变量，多个变量共同操作的变量
 * 同步监视器：俗称锁，任何一个类的对象都能充当同步监视器，多个线程必须要公用同一把锁
 * 这里一定要是唯一的
 *
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，可以将此方法声明为同步方法
 *
 *
 *
 * 同步的方式，解决了线程的安全问题
 * 操作同步代码块的时候，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低
 *
 * @author axiuf
 * @create 2020/12/15-10:55
 */

class Window implements Runnable
{
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                try
                {
                    Thread.currentThread().sleep(101);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (ticket > 0)
                {
                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else
                {
                    break;
                }
            }
        }

    }
}

public class WindowTest
{
    public static void main(String[] args)
    {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t3.start();
        t1.start();
        t2.start();
    }
}
