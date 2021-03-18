package io.github.axiuf.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.EduSubject;
import io.github.axiuf.eduservice.entity.EduTeacher;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;
import io.github.axiuf.eduservice.entity.vo.EduTeacherQuery;
import io.github.axiuf.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo)
    {
        eduCourseService.updateCourseInfo(courseInfoVo);

        return R.ok();
    }

    @GetMapping("/getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id)
    {
        CoursePublishVo coursePublishVo = eduCourseService.publishCourseInfo(id);

        return R.ok().data("publishCourseInfo", coursePublishVo);
    }

    @PostMapping("/publishCourse/{id}")
    public R publishCourse(@PathVariable String id)
    {
        EduCourse eduCourse = new EduCourse();

        eduCourse.setId(id);

        eduCourse.setStatus("Normal");

        eduCourseService.updateById(eduCourse);

        return R.ok();
    }

    @GetMapping("/getCourseList")
    public R getCourseList()
    {
        List<EduCourse> list = eduCourseService.list(null);

        return R.ok().data("list", list);
    }

    // 4. 带条件的分页查询
    @ApiOperation(value = "条件查询分页课程列表")
    @PostMapping ("/pageCourseCondition/{page}/{limit}")
    public R pageCourseCondition(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "条件查询信息")
            @RequestBody(required = false) EduCourse courseQuery){

        // 创建分页对象
        Page<EduCourse> pageParam = new Page<>(page, limit);
        // 创建条件查询对象
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();

        String title = courseQuery.getTitle();
        String subjectParentId = courseQuery.getSubjectParentId();
        String subjectId = courseQuery.getSubjectId();
        String teacherId = courseQuery.getTeacherId();

        if (!StringUtils.isEmpty(title))
        {
            queryWrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(subjectParentId))
        {
            queryWrapper.eq("subjectParentId", subjectParentId);
        }
        if (!StringUtils.isEmpty(subjectId))
        {
            queryWrapper.eq("subjectId", subjectId);
        }
        if (!StringUtils.isEmpty(teacherId))
        {
            queryWrapper.eq("teacherId", teacherId);
        }

        queryWrapper.orderByDesc("gmt_create");

        // 根据给定的条件查询数据并封装到Wrapper中
        eduCourseService.page(pageParam, queryWrapper);

        long total = pageParam.getTotal();
        List<EduCourse> records = pageParam.getRecords();

        return  R.ok().data("total", total).data("rows", records);
    }

    @DeleteMapping("/deleteCourseById/{id}")
    public R deleteCourseById(@PathVariable String id)
    {
        eduCourseService.removeCourseInfo(id);

        return R.ok();
    }


}

