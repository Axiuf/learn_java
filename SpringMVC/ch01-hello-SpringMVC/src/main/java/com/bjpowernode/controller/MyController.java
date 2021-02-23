package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shan Cheng
 * @date 2021/2/22
 */

@Controller

public class MyController
{
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome()
    {
        System.out.println("MyController开始执行");
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "使用注解的SpringMVC应用");
        mv.addObject("fun", "doSome");

        mv.setViewName("show");

        return mv;
    }
}