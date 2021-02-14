package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.collectionType.Course;
import com.atguigu.spring5.collectionType.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Shan Cheng
 * @date 2021/2/3-22:54
 */
public class TestSpring5Demo2
{
    @Test
    public void test1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Stu stu = context.getBean("stu", Stu.class);

        stu.test();
    }

    @Test
    public void test2()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course myBean = context.getBean("myBean", Course.class);

        System.out.println(myBean);
        
        context.close();
    }

    @Test
    public void test3()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);

        emp.test();
    }
}
