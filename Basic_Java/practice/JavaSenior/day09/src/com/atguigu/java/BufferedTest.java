package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2. 作用：
 * 提高读写速度，因为内部增加了提供了一个缓冲区
 *
 * 3. 处理流
 * 就是套接在已有的流的基础上
 *
 * @author Shan Cheng
 * @date 2020/12/24-15:25
 */
public class BufferedTest
{
    @Test
    public void BufferedStreamTest()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try
        {
            // 1. 造文件
            File scrFile = new File("xx.jpg");
            File destFile = new File("xx.jpg");

            // 2. 造流
            // 2.1 造节点流
            fis = new FileInputStream(scrFile);
            fos = new FileOutputStream(destFile);

            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1)
            {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 4. 资源关闭
            // 要求：先关闭外层的流，再关闭内层的流
            if (bis != null)
            {
                try
                {
                    bis.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (bos != null)
            {
                try
                {
                    bos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            // 说明：关闭外层的时候，会自动关闭内层
//            fis.close();
//            fos.close();
        }
    }
}
