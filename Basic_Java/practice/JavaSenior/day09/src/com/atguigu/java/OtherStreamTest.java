package com.atguigu.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * 其他流的使用
 * 1. 标准的输入、输出流
 * 2. 打印流
 * 3. 数据流
 *
 * @author Shan Cheng
 * @date 2020/12/24-20:35
 */
public class OtherStreamTest
{
    /*
    1. 标准的输入、输出流
    1.1
    System.in: 标准的输入流，默认从键盘输入
    System.out: 标准的输出流，默认从控制台输出

    1.2
    System类的SetIn(InputStream is) / setOut(PrintStream ps)

    方法一：使用Scanner实现，调用next()返回一个字符串
    方法二：
     */

    @Test
    public void test1()
    {
        BufferedReader br = null;
        try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true)
            {
                System.out.print("请输入字符串: ");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data))
                {
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = data.toUpperCase(Locale.ROOT);
                System.out.println(upperCase);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    2. 打印流：PrintStream 和 PrintWriter
     */

    @Test
    public void test2()
    {
        for (int i = 0; i < 255; i++)
        {
            System.out.print((char) i);
            if (i % 50 == 0)
            {
                System.out.println();
            }
        }
    }

    // 3. 数据流
}
