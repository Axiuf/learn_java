package com.atguigu.spring5.aopAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @date 2021/2/4-21:40
 */

@Component
@Aspect
@Order(1)
public class UserProxy
{
    @Pointcut(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
    public void pointDemo()
    {

    }

    @Before(value = "pointDemo())")
    public void Before1()
    {
        System.out.println("before......");
    }

    @After(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
    public void after()
    {
        System.out.println("after......");
    }

    @AfterReturning(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
    public void afterReturning()
    {
        System.out.println("afterReturning......");
    }

    @AfterThrowing(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
    public void afterThrowing()
    {
        System.out.println("afterThrowing......");
    }

//    @Around(value = "execution(* com.atguigu.spring5.aopAnnotation.User.add(..))")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
//    {
//        System.out.println("环绕之前......");
//        proceedingJoinPoint.proceed();
//        System.out.println("环绕之后......");
//    }
}