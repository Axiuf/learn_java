package com.bjpowernode.controller;

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
@RequestMapping(value = "/test")
public class MyController
{
    @RequestMapping(value = {"/some.do", "/some2.do"}, method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                               HttpSession httpSession)
    {
        System.out.println("doSome开始执行");
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "使用注解的SpringMVC应用");
        mv.addObject("fun", "doSome");

        System.out.print("name = ");
        System.out.println(httpServletRequest.getParameter("name"));

        mv.setViewName("show");

        return mv;
    }

    @RequestMapping(value = {"/other.do", "/other2.do"}, method = RequestMethod.POST)
    public ModelAndView doOther(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                HttpSession httpSession)
    {
        System.out.println("doOther开始执行");
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "使用注解的SpringMVC应用");
        mv.addObject("fun", "doOther");

        System.out.print("name = ");
        System.out.println(httpServletRequest.getParameter("name"));

        mv.setViewName("show");

        return mv;
    }
}