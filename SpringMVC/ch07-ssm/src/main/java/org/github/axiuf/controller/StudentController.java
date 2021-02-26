package org.github.axiuf.controller;

import org.github.axiuf.domain.Student;
import org.github.axiuf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/24
 */

@Controller
@RequestMapping("/student")
public class StudentController
{
    private StudentService service;

    public StudentService getService()
    {
        return service;
    }

    @Autowired
    public void setService(StudentService service)
    {
        this.service = service;
    }

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student)
    {
        ModelAndView mv = new ModelAndView();

        String resultString = "学生[" + student.getName() + "]: ";

        int nums = service.addStudent(student);

        resultString += nums>0?"注册成功":"注册失败";

        mv.addObject("resultString", resultString);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/showStudents.do")
    @ResponseBody
    public List<Student> showStudent()
    {
        return service.showStudents();
    }
}
