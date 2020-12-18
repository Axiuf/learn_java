package com.atguigu.java;

/**
 * @author axiuf
 * @create 2020/12/17-22:35
 */
public class IDEADebug
{
    public static void main(String[] args)
    {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb);
        System.out.println(sb.length());

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
