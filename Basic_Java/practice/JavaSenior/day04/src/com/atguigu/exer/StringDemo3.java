package com.atguigu.exer;

import org.junit.Test;

/**
 * 找两个字符串的最大相同子串
 *
 * @author axiuf
 * @create 2020/12/17-21:28
 */
public class StringDemo3
{
    public String getMaxSameString(String str1, String str2)
    {
        String MaxStr = (str1.length() >= str2.length())? str1 : str2;
        String MinStr = (str1.length() < str2.length())? str1 : str2;

        for (int i = MinStr.length(); i > 0; i--)
        {
            for (int j = 0; j <= MinStr.length() - i; j++)
            {
                String st = MinStr.substring(j, j + i);
                if (MaxStr.contains(st))
                {
                    return st;
                }
            }
        }

        return null;
    }

    @Test
    public void test()
    {
        String str1 = "asjfljsdfiojabcdefglfkajslkdfjaouild;kahfnl;kjhf";
        String str2 = "abcdefg";
        System.out.println(getMaxSameString(str1, str2));
    }
}
