package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author axiuf
 * @create 2020/12/19-10:30
 */
public class TestNull
{
    public static void main(String[] args)
    {
        String[] str = new String[]{"A", "B", "C"};
        System.out.println(Arrays.toString(str));

//        System.out.println(str[1]);
//        str[1] = "";
//        System.out.println(Arrays.toString(str));

//        str[1] = null;
//        System.out.println(Arrays.toString(str));

        str[2] = null;
        System.out.println(Arrays.toString(str));
    }


    @Test
    public void test()
    {
        int[] arr = new int[10];
        arr[1] = 1;
        System.out.println(Arrays.toString(arr));
    }
}
