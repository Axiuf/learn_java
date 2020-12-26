package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1. ObjectInputStream 和 ObjectOutputStream
 * 2. 作用：存储或者读取基本数据类型数据或者对象的处理流
 * 3. 除了当前的类中需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的
 *      默认基本数据类型也是可序列化的
 *
 * @author Shan Cheng
 * @date 2020/12/25-12:19
 */
public class ObjectInputOutputStream
{
    /*
    序列化的过程：将内存中的java对象保存到磁盘中或者通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream()
    {
        ObjectOutputStream oos = null;
        try
        {
            // 1. 造文件 造流
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            // 2. 实际的写出过程
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush(); // 刷新操作

            oos.writeObject(new Person("Cheng", 25));
            oos.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 3. 关闭
            if (oos != null)
            {
                try
                {
                    oos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘中的文件还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream()
    {
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            obj = ois.readObject();
            System.out.println((Person) obj);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            if (ois != null)
            {
                try
                {
                    ois.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
