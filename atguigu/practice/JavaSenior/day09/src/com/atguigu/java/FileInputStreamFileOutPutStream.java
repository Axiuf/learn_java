package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutPutStream的使用
 *
 * 结论：
 * 1. 对于文本文件（.txt, .java, .c, .cpp)，使用字符流进行处理
 * 2. 对于非文本文件（.jpg, .mp3, .avi, .ppt, .doc)，使用字节流进行处理
 *
 *
 * @author Shan Cheng
 * @date 2020/12/24-14:51
 */
public class FileInputStreamFileOutPutStream
{
    // 使用字节流处理文本文件可能出现乱码
    @Test
    public void testFileInputStream()
    {
        FileInputStream fis = null;
        try
        {
            File file = new File("hello.txt");

            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1)
            {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    // 实现对图片的复制操作
    @Test
    public void testFileInputOutputStream()
    {
        File srcFile = new File("");
    }

    // 指定路径下文件的复制

}
