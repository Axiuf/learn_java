package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁 JDK5.0新增
 *
 * synchronized和lock方式的异同：两者都可以解决线程安全的问题
 * synchronized机制在执行相应的同步代码逻辑之后，自动释放同步监视器
 * Lock需要手动的启动同步（lock()），同时结束同步也需要手动的去实现
 *
 * 建议优先使用lock，然后是同步代码块（已经静茹了方法体，分配了相应的资源），最后使用同步方法（在方法体之外）
 *
 * 如何解决线程安全的问题Lock，synchronized（同步代码块，同步方法）
 *
 *
 * @author axiuf
 * @create 2020/12/15-16:40
 */

class Window implements Runnable
{
    private int ticket = 100;

    // 1. 实例化ReentrantLock对象
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                // 2. 调用锁定的方法
                lock.lock();

                if (ticket > 0)
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                }
            } finally
            {
                // 3. 调用解锁的方法
                lock.unlock();
            }
        }
    }
}

public class LockTest
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

        t1.start();
        t2.start();
        t3.start();
    }
}