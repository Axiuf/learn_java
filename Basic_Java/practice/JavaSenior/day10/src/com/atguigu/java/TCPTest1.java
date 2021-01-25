package com.atguigu.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 * @author Shan Cheng
 * @date 2020/12/25-19:31
 */
public class TCPTest1
{

    // 客户端
    @Test
    public void test1()
    {
        Socket socket = null;
        OutputStream os = null;
        try
        {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (os != null)
            {
                try
                {
                    socket.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }





    }

    // 服务端
    @Test
    public void server() throws IOException
    {
        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1)
        {
            String s = new String(buffer, 0, len);
            System.out.println(s);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    }

}
