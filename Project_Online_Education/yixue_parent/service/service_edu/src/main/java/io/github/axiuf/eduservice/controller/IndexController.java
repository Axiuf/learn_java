package io.github.axiuf.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.EduTeacher;
import io.github.axiuf.eduservice.service.EduCourseService;
import io.github.axiuf.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/12
 */
@RestController
@RequestMapping("/eduservice/index")
@CrossOrigin
public class IndexController {

    private EduCourseService courseService;
    private EduTeacherService teacherService;

    @Autowired
    public void setCourseService(EduCourseService courseService)
    {
        this.courseService = courseService;
    }

    @Autowired
    public void setTeacherService(EduTeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    //查询前8条热门课程，查询前4条名师
    @GetMapping("/getIndex")
    public R index() {
        //查询前8条热门课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<EduCourse> eduList = courseService.list(wrapper);

        //查询前4条名师
        QueryWrapper<EduTeacher> wrapperTeacher = new QueryWrapper<>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<EduTeacher> teacherList = teacherService.list(wrapperTeacher);

        return R.ok().data("eduList",eduList).data("teacherList",teacherList);
    }
}
