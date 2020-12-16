package com.atguigu.java2;

/**
 * 线程的通信：使用两个线程交替打印1-100
 *
 * 涉及到的三个方法：
 * wait（）一旦执行此方法，则当前的线程进入阻塞状态，并释放同步监视器
 * notify（） 一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程，则唤醒优先级高的进程
 * notifyAll（） 唤醒所有的沉睡wait的进程
 *
 * 说明：wait，notify，notifyAll三个方法的调用者必须是同步方法或者同步代码块中的同步监视器
 *  否则，会出现IllegalMonitorStateException异常
 *  这三个方法是定义在Object类中的
 *
 *  面试题，sleep方法和wait方法的异同
 *  都会使得当前的线程进入阻塞状态
 *  不同点：sleep声明在Thread类中的静态方法，wait声明在Object类中
 *  调用的范围不同，sleep方法可以在任何需要的场景下调用，wait方法必须要使用同步代码块或者同步方法中，用于控制线程通信
 *  是否释放同步监视器的问题：如果两个方法都是用在同步代码块或者同步方法中，sleep不会释放同步监视器，wait则会释放同步监视器。
 *
 *
 * @author axiuf
 * @create 2020/12/15-17:31
 */

class Number implements Runnable
{
    private int num = 1;

    @Override
    public void run()
    {
        while (true)
        {

            synchronized (this)
            {
                notify();

                if (num <= 100)
                {
                    System.out.println(Thread.currentThread().getName() + "正在打印：" + num);
                    num++;

                    try
                    {
                        // 这里使得调用方法的的进程进入阻塞
                        wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                    break;
            }
        }
    }
}


public class CommunicationTest
{
    public static void main(String[] args)
    {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
