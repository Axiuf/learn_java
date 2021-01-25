package com.atguigu.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1. 创建一个实现了Runnable接口的类
 * 2. 创建一个该类的对象
 * 3. 把该对象作为参数传递给Thread类的构造器 创建一个Thread类的对象
 * 4. 调用Thread对象的start方法
 *
 * @author axiuf
 * @create 2020/12/14-23:21
 */

class MThread implements Runnable
{

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}

public class ThreadTest1
{
    public static void main(String[] args)
    {
        MThread m1 = new MThread();

        Thread t1 = new Thread(m1);
        t1.start();
    }
}
