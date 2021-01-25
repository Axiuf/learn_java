package com.atguigu.java;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1. 操作数据的单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）       缓冲流（处理流的一种）
 * InputStream      FileInputStream         BufferedInputStream
 * OutStream        FileOutputStream        BufferedOutputStream
 * Reader           FileReader              BufferedReader
 * Writer           FileWriter              BufferedWriter
 *
 *
 * @author Shan Cheng
 * @date 2020/12/24-10:06
 */
public class FileReaderWriterTest
{
    public static void main(String[] args)
    {
        File file = new File("hello.txt"); // 相较于当前Project
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 将day09下的hello.txt文件读入程序中，并输出到控制台
     */
    @Test
    public void testFileReader1()
    {
        FileReader fr = null;
        try
        {
            // 1. 实例化具体的File类的对象，指明要操作的文件
            File file = new File("hello.txt"); // 相较于当前Module
            System.out.println(file.getAbsolutePath());

            // 2. 提供具体的流
            fr = new FileReader(file);

            // 3. 数据的读入
            // read(): 返回读入的一个字符。如果达到文件的末尾，返回-1
//        int data = fr.read();
//        while (data != -1)
//        {
//            System.out.println((char) data);
//            data = fr.read();
//        }

            // 方式二：
            int data;
            while ((data = fr.read()) != -1)
            {
                System.out.print((char) data);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 4. 流的关闭操作
            try
            {
                if (fr != null)
                    fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    // 对read()操作升级：使用read重载方法
    @Test
    public void testFileReader2()
    {
        FileReader fr = null;
        try
        {
            // 1. File类的实例化
            File file = new File("hello.txt");

            // 2. 流的实例化
            fr = new FileReader(file);

            // 3. 读入操作
            // read(char[] cbuf): 返回每次读入cbuf数组中字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1)
            {
                for (int i = 0; i < len; i++)
                {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 4. 资源的关闭
            try
            {
                fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    /**
     * 从内存中写出数据到硬盘的文件
     *
     * 说明：
     * 1. 输出操作，对应的File可以不存在，如果不存在，在输出的过程中，会自动的创建文件
     *      如果存在
     *
     * 2. File对应的硬盘中的文件不存在，在输出的过程中，会自动的创建此文件
     *      File对应的硬盘中对应文件如果存在：
     *          如果流使用的构造器是FileWriter(file, false) / FileWriter(file): 对原有文件的覆盖
     *          如果流使用的构造器是FileWriter(file, true): 不会对原有的文件覆盖，而是在原有文件的基础上追加内容
     */
    @Test
    public void testFileWriter() throws IOException
    {
        // 1.提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");

        // 2. 提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file, true);

        // 3. 写出的操作
        fw.write("I have a dream!\n");
        fw.write("you need to have a dream!\n");

        // 4. 流资源的关闭
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter()
    {
        FileReader fr = null;
        FileWriter fw = null;
        try
        {
            // 1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            // 2. 创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile, false);

            // 3. 数据的读入和写书操作
            char[] cbuf = new char[5];
            int len; // 记录每次读入到cbuf数组中字符的个数
            while ((len = fr.read(cbuf)) != -1)
            {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 4. 关闭资源
            try
            {
                fw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                fr.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
