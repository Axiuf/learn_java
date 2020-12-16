package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式4，使用线程池
 *
 * 好处：
 * 1. 提高响应的速度
 * 2. 降低资源消耗 （重复利用线程池中的线程，不需要每次都创建）
 * 3. 便于线程管理
 *
 *
 * @author axiuf
 * @create 2020/12/16-12:38
 */
class NumberThread implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }
    }
}

class NumberThread2 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 != 0)
            {
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }
    }
}

public class ThreadPool
{
    public static void main(String[] args)
    {
        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service1.setCorePoolSize(15);
//        ((ThreadPoolExecutor) service).setKeepAliveTime(0xe);

        // 设置线程池的属性
        System.out.println(service.getClass());

        // 2. 执行指定的线程的操作，需要提供实现Runnable接或Callable接口实现类的对象
        service.execute(new NumberThread()); // 适合使用与Runnable
        service.execute(new NumberThread2()); // 适合使用与Runnable
//        service.submit(); // 适合适用于Callable

        // 关闭连接池
        service.shutdown();
    }
}


