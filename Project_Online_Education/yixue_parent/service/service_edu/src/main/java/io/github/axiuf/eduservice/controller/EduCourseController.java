package io.github.axiuf.eduservice.controller;


import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;
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

    @GetMapping("/getCourseInfo/{courseId}")
    public R getCourseId(@PathVariable String courseId)
    {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo)
    {
        eduCourseService.updateCourseInfo(courseInfoVo);

        return R.ok();
    }

    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id)
    {
        CoursePublishVo coursePublishVo = eduCourseService.publishCourseInfo(id);

        return R.ok().data("publishCourseInfo", coursePublishVo);
    }

}

