package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Shan Cheng
 * @date 2021/2/22
 */

@Controller
public class MyController
{
    @RequestMapping(value = "ReceiveProperty.do")
    public ModelAndView ReceiveProperty(String name, Integer age)
    {
        System.out.println("ReceiveProperty开始执行");

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "方法开始执行");
        mv.addObject("fun", "ReceiveProperty");
        mv.addObject("name", name);
        mv.addObject("age", age);

        System.out.println("name=" + name);
        System.out.println("age=" + age);

        mv.setViewName("show");

        return mv;
    }

    @RequestMapping(value = "ReceiveObject.do")
    public ModelAndView ReceiveObject(Student student)
    {
        System.out.println("ReceiveObject开始执行");

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这里是对象传递多个参数");
        mv.addObject("fun", "ReceiveObject");
        mv.addObject("name", student.getName());
        mv.addObject("age", student.getAge());

        System.out.println("name=" + student.getName());
        System.out.println("age=" + student.getAge());

        mv.setViewName("show");

        return mv;
    }
}