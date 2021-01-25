package com.atguigu.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 二、网络编程中的两个要素
 * 1. 对应问题1：IP和端口号
 * 2. 对应问题2：提供网络通信协议
 *
 * 网络要素一：IP和端口号
 * 1、IP：唯一的标识 Internet上的计算机（通信实体）
 * 2、在java中使用InetAddress类代表IP
 * 3、IP分类：IPv4和IPv6 万维网和局域网
 * 4、域名 www.baidu.com www.mi.com www.sina.com
 * 5. 本地回路地址：127.0.0.1 对应着：localhost
 * 6. 如何实例化InetAddress：两个方法：getByName() getLocalHost()
 *
 *
 *
 * @author Shan Cheng
 * @date 2020/12/25-18:20
 */
public class InternetAdderssTest
{
    public static void main(String[] args)
    {
        try
        {
            // File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);

            System.out.println(InetAddress.getLocalHost());

            // getHostName()
            inet2.getHostName();



        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }

    }
}
