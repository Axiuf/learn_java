package com.atguigu.exer;

import org.junit.Test;

/**
 * @author axiuf
 * @create 2020/12/17-21:09
 */

public class StringDemo2
{
    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     */
    public int getCount(String mainStr, String subStr)
    {
        int count = 0;
        int startIndex = 0;
        while (startIndex < mainStr.length())
        {
            int index = mainStr.indexOf(subStr, startIndex);
            if (index != -1)
            {
                count++;
                startIndex = index + subStr.length();
            }
            else
                break;

        }
        return count;
    }

    @Test
    public void test1()
    {
        String mainStr = "abslkjfklajablksjfljaablksdjflj";
        String subStr = "ab";
        System.out.println(getCount(mainStr, subStr));
    }
}
