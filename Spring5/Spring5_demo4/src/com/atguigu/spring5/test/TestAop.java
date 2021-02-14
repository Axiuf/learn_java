package com.atguigu.spring5.test;

import com.atguigu.spring5.aopAnnotation.User;
import com.atguigu.spring5.aopXML.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Shan Cheng
 * @date 2021/2/4-21:58
 */
public class TestAop
{
    @Test
    public void testAopAnnotation()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        User user = context.getBean("user", User.class);

        user.add();
    }

    @Test
    public void testAopXML()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        book.buy();
    }
}
