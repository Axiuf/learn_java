package io.github.axiuf.eduservice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.chapter.ChapterVo;
import io.github.axiuf.eduservice.entity.frontvo.CourseQueryVo;
import io.github.axiuf.eduservice.entity.frontvo.CourseWebVo;
import io.github.axiuf.eduservice.service.EduChapterService;
import io.github.axiuf.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Shan Cheng
 * @since 2021/3/19
 */

@RestController
@CrossOrigin
@RequestMapping("/eduservice/coursefront")
public class FrontCourseController
{
    @Autowired
    private EduCourseService eduCourseService;

    @ApiOperation(value = "分页课程列表")
    @PostMapping(value = "{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
            @RequestBody(required = false) CourseQueryVo courseQuery){
        Page<EduCourse> pageParam = new Page<EduCourse>(page, limit);
        Map<String, Object> map = eduCourseService.pageListWeb(pageParam, courseQuery);
        return  R.ok().data(map);
    }

    @Autowired
    private EduChapterService chapterService;

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping(value = "{courseId}")
    public R getById(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @PathVariable String courseId){

        //查询课程信息和讲师信息
        CourseWebVo courseWebVo = eduCourseService.selectInfoWebById(courseId);

        //查询当前课程的章节信息
        List<ChapterVo> chapterVoList = chapterService.getChapterByCourse(courseId);

        return R.ok().data("course", courseWebVo).data("chapterVoList", chapterVoList);
    }
}
