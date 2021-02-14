package com.atguigu.spring5.aopAnnotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @date 2021/2/4-22:22
 */

@Component
@Aspect
@Order(3)
public class PersonProxy
{
    @Before(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
    public void before2()
    {
        System.out.println("person before......");
    }
}
