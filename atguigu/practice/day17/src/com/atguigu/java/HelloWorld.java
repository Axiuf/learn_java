package com.atguigu.java;

import java.util.Arrays;

public class HelloWorld
{
    public static void main(String[] args)
    {
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("HelloWorld.main");
        System.out.println("true = " + true);
    }

    public static void test()
    {
        System.out.println("true = " + true);
    }
}