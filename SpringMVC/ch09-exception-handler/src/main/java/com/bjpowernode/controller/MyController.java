package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

    @RequestMapping(value = "returnVoid-ajax.do")
    public void returnVoid(HttpServletResponse response, String name, Integer age) throws IOException
    {
        System.out.println("returnVoid开始执行");

        // 处理ajax，使用jason做数据的格式

        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        if (student != null)
        {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(student);
            System.out.println("Student装换的json====" + json);
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    @RequestMapping(value = "returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age)
    {
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);

        return student;
    }

    @RequestMapping(value = "exception.do")
    public ModelAndView doException(String name, Integer age)
    {
        ModelAndView mv = new ModelAndView();

        mv.addObject("myName", name);
        mv.addObject("myAge", age);

        mv.setViewName("show");

        return mv;

    }
}