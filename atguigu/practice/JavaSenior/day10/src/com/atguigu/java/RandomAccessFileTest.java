package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;

/**
 * RandomAccessFile的使用
 * 1. RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2. RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * @author Shan Cheng
 * @date 2020/12/25-13:42
 */
public class RandomAccessFileTest
{
    @Test
    public void  test1()
    {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try
        {
            raf1 = new RandomAccessFile(new File("Object.dat"), "r");
            raf2 = new RandomAccessFile(new File("Object1.dat"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1)
            {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (raf1 != null)
            {
                try
                {
                    raf1.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (raf2 != null)
            {
                try
                {
                    raf2.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}