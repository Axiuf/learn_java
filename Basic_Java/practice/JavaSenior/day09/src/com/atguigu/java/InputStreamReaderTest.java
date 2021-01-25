package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1. 转换流：属于字符流
 *  InputStreamReader: 将一个字节的输入流装换位字符的输入流
 *  OutputStreamWriter：将一个字符的输出流转换为字节的输入流
 *
 *  2. 作用
 *
 *  3. 编码： 字节、字节数组 ---》字符数组、字符串
 *     解码：  字符数组、字符串 --》字节、字节数组
 *
 *  4. 字符集
 * @author Shan Cheng
 * @date 2020/12/24-16:54
 */
public class InputStreamReaderTest
{
    @Test
    public void test1() throws UnsupportedEncodingException, FileNotFoundException
    {
//        FileInputStream fis = new FileInputStream("dbcp.txt");

        // 参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] cubf = new char[20];

        int len;

        FileOutputStream fis = new FileOutputStream("ss.txt");
        OutputStreamWriter putStreamWriter = new OutputStreamWriter(fis);

    }
}