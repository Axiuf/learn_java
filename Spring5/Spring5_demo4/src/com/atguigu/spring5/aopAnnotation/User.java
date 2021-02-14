package com.atguigu.spring5.aopAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @date 2021/2/4-21:38
 */

@Component
public class User
{
    public void add()
    {
        System.out.println("add......");
    }
}