package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Shan Cheng
 * @date 2021/2/4-16:31
 */
public class TestSpring5Demo
{
    @Test
    public void testService()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);

        userService.add();
    }
}
