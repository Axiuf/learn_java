package io.github.axiuf.eduservice.controller;


import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/edu-course")
public class EduCourseController {
    private EduCourseService eduCourseService;

    @Autowired
    public void setEduCourseService(EduCourseService eduCourseService)
    {
        this.eduCourseService = eduCourseService;
    }

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo)
    {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);

        return R.ok().data("cid", id);
    }
}

