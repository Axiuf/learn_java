package com.atguigu.spring5.service;

import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @date 2021/2/4-16:27
 */

// 这里加上注解的作用等同于在xml配置文件中写 <bean id="userService" class="com.atguigu.spring5.service.UserService"></bean>
// 注解的value值是等同于赋给配置中value值，默认为类名首字母改小写

@Component(value = "userService")
public class UserService
{
    public void add()
    {
        System.out.println("service add......");
    }
}