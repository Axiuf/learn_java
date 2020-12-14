package com.atguigu.java;

/**
 * Thread类中的常用方法
 * getName()
 * setName()
 * currentThread()
 * run()
 * start()
 * yield() 释放当前CPU的执行
 * join() 在线程a中调用b的join()方法，线程a阻塞，线程b执行完之后，线程a才结束阻塞，简单讲就是插入完成
 * stop() 强制线程声明周期结束 已过时
 * sleep(long millis)
 * isAlive() 判断线程是否存活
 *
 * 线程的优先级：
 * 1. MAX_PRIORITY: 10
 * MIN_PRIORITY: 10
 * NORM_PRIORITY: 10
 *
 *
 * @author axiuf
 * @create 2020/12/14-21:49
 */

class HelloThread extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)
            {
//

                System.out.println(Thread.currentThread().getName() + ":" + "p" + getPriority() + ", " + i);
            }

//            if (i % 20 == 0)
//            {
//                this.yield();
//            }
        }
    }

    public HelloThread(String name)
    {
        super(name);
    }
}

public class ThreadMethodTest
{
    public static void main(String[] args)
    {
        HelloThread h1 = new HelloThread("Thread: 1");

//        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + "p" + Thread.currentThread().getPriority() + ", " + i);
            }

            if (i == 20)
            {
                try
                {
                    h1.join();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(Thread.currentThread().isAlive());

        System.out.println(h1.isAlive());
    }
}