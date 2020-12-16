package com.atguigu.exer;

/**
 * @author axiuf
 * @create 2020/12/16-10:37
 */

class TestCase
{
    private static int i = 0;

    public static void P()
    {
        i++;
        System.out.println(i);
    }

    public TestCase()
    {
    }

    public static int getI()
    {
        return i;
    }
}

public class Test extends TestCase
{
    public static void main(String[] args)
    {
        System.out.println(getI());
    }
}
