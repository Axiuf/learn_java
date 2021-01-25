package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author Shan Cheng
 * @date 2020/12/26-16:50
 */
public class ClassLoaderTest
{
    @Test
    public void test1()
    {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 调用系统类加载器的getParent(): 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 调用扩展类加载器的getParent(): 无法获取引导类加载器
        // 引导加载器主要负责加载java的核心内库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        System.out.println(String.class.getClassLoader());
    }

    @Test
    public void test2() throws IOException
    {
        Properties pros = new Properties();
        // 此时的文件默认在当前的module下
        FileInputStream fis = new FileInputStream("jdbc.properties");

        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + ", password=" + password);
    }
}
