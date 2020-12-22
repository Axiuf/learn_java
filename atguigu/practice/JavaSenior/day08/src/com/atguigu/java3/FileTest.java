package com.atguigu.java3;

import org.junit.Test;

import javax.lang.model.element.ModuleElement;
import javax.print.attribute.standard.RequestingUserName;
import java.io.File;
import java.net.URI;
import java.util.Date;

/**
 * @author Shan Cheng
 * @date 2020/12/22-17:07
 */
public class FileTest
{
    /*
    1. 如何创建File类的实例
    2. 相对路径 相较于某个路径下，指明的路径/ 绝对路径： 包含盘符在内的文件或者文件夹的路径
     */
    @Test
    public void test1()
    {
        File file1 = new File("hello.txt"); // 相对于当前的module
        File file2 = new File("D:\\flasjfl\\fajdlfkj\\fdajskdjf.txt");

        System.out.println(file1);
        System.out.println(file2);

        File file3 = new File("D:\\flkjsadf\\dfsah", "lksjf");
        System.out.println(file3);

        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2()
    {
        File file1 = new File("hello.txt");
        File file2 = new File("c:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3()
    {
        File file = new File("C:\\Users\\axiuf\\Desktop\\learn_java\\atguigu\\practice\\JavaSenior");
        String[] list = file.list();
        for (String s : list)
        {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files)
        {
            System.out.println(f);
        }



    }

    /*
        把文件重命名为指定的文件路径
         */
    @Test
    public void test4()
    {
        File file1 = new File("hello.txt");
        File file2 = new File("hi.txt");

        System.out.println(file1.renameTo(file2));
        // 移动+改名


    }

    @Test
    public void test5()
    {
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

//        File2 file2 = new File("")
    }
}
