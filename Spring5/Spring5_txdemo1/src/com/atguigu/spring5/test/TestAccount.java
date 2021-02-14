package com.atguigu.spring5.test;

import com.atguigu.spring5.config.TxConfig;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Shan Cheng
 * @date 2021/2/6-20:15
 */
public class TestAccount
{
    @Test
    public void testAccount1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml ");

        UserService userService = context.getBean("userService", UserService.class);

        userService.accountMoney();
    }

    @Test
    public void testAccount2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml ");

        UserService userService = context.getBean("userService", UserService.class);

        userService.accountMoney();
    }

    @Test
    public void testAccount3()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        userService.accountMoney();
    }
}
