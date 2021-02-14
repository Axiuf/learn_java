package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Shan Cheng
 * @date 2021/2/2-22:35
 */
public class TestBean
{
    @Test
    public void test1()
    {
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        // 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void test2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }
}