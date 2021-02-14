package com.atguigu.spring5.factoryBean;

import com.atguigu.spring5.collectionType.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Shan Cheng
 * @date 2021/2/4-0:09
 */
public class MyBean implements FactoryBean<Course>
{
    @Override
    public Course getObject() throws Exception
    {
        Course course = new Course();
        course.setName("abs");
        return course;
    }

    @Override
    public Class<?> getObjectType()
    {
        return null;
    }

    @Override
    public boolean isSingleton()
    {
        return false;
    }
}
