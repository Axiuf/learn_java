package com.atguigu.exer;

import org.junit.Test;

/**
 * @author axiuf
 * @create 2020/12/17-20:35
 */
public class StringDemo
{
    /*
    讲一个字符串进行翻转，将字符串中指定的部分进行反转
     */

    public String reverse(String str, int startIndex, int endIndex)
    {
        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--)
        {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        return new String(arr);
    }

    public String reverse2(String str, int startIndex, int endIndex)
    {
        return str.substring(0, startIndex) + new StringBuffer(str.substring(startIndex, endIndex + 1)).reverse() +
                str.substring(endIndex + 1, str.length());
    }

    public String reverse3(String str, int startIndex, int endIndex)
    {
        StringBuilder sb = new StringBuilder(str.length());

        sb.append(str.substring(0, startIndex));

        for (int i = endIndex; i >= startIndex; i--)
        {
            sb.append(str.charAt(i));
        }

        sb.append(str.substring(endIndex + 1));

        return sb.toString();
    }

    @Test
    public void testReverse()
    {
        String str = "abcdefg";
        System.out.println(reverse(str, 2, 6));
        System.out.println(reverse2(str, 0, 6));
        System.out.println(reverse3(str, 0, 6));
        System.out.println(str.substring(7, 7));
    }
}
