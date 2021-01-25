package com.atguigu.java;

/**
 * 在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑使用当前类充当同步监视器
 *
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 * 2. 非静态的同步方法的监视是this
 * 3. 静态的同步对象的同步监视是当前类本身
 *
 *
 * @author axiuf
 * @create 2020/12/15-11:26
 */
class Window4 extends Thread
{
    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run()
    {
        while (true)
        {
            show();
        }
    }

    private static synchronized void show()
    {
        if (ticket > 0)
        {
            try
            {
                Thread.currentThread().sleep(5);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4
{
    public static void main(String[] args)
    {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}