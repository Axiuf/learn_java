package io.github.axiuf.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.EduCourseDescription;
import io.github.axiuf.eduservice.entity.frontvo.CourseQueryVo;
import io.github.axiuf.eduservice.entity.frontvo.CourseWebVo;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;
import io.github.axiuf.eduservice.mapper.EduCourseMapper;
import io.github.axiuf.eduservice.service.EduChapterService;
import io.github.axiuf.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.axiuf.eduservice.service.EduVideoService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    private EduCourseDescriptionServiceImpl eduCourseDescriptionService;
    private EduVideoService eduVideoService;
    private EduChapterService eduChapterService;

    @Autowired
    public void setEduVideoService(EduVideoService eduVideoService)
    {
        this.eduVideoService = eduVideoService;
    }

    @Autowired
    public void setEduChapterService(EduChapterService eduChapterService)
    {
        this.eduChapterService = eduChapterService;
    }

    @Autowired
    public void setEduCourseDescriptionService(EduCourseDescriptionServiceImpl eduCourseDescriptionService)
    {
        this.eduCourseDescriptionService = eduCourseDescriptionService;
    }

    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo)
    {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);

        int insert = baseMapper.insert(eduCourse);
        String courseId = eduCourse.getId();

        if (insert <= 0)
        {
            throw new YixueException(20001, "添加课程信息失败");
        }


        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo, eduCourseDescription);
        eduCourseDescription.setId(courseId);

        boolean save = eduCourseDescriptionService.save(eduCourseDescription);


        return courseId;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId)
    {
        EduCourse eduCourse = baseMapper.selectById(courseId);

        EduCourseDescription courseDescription = eduCourseDescriptionService.getById(courseId);

        CourseInfoVo courseInfoVo = new CourseInfoVo();

        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        BeanUtils.copyProperties(courseDescription, courseInfoVo);

        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo)
    {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);

        int update = baseMapper.updateById(eduCourse);
        if (update == 0)
        {
            throw new YixueException(200001, "修改课程信息失败");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo, eduCourseDescription);
        eduCourseDescriptionService.getById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String id)
    {
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);

        return publishCourseInfo;
    }

    @Override
    public void removeCourseInfo(String id)
    {
        eduVideoService.removeVideoByCourseId(id);

        eduChapterService.removeChapterByCourseId(id);

        eduCourseDescriptionService.removeById(id);

        int delete = baseMapper.deleteById(id);

        if (delete == 0)
        {
            throw new YixueException(20001, "删除失败");
        }

    }

    /**
     * 根据讲师id查询当前讲师的课程列表
     * @param teacherId
     * @return
     */
    @Override
    public List<EduCourse> selectByTeacherId(String teacherId) {

        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<EduCourse>();

        queryWrapper.eq("teacher_id", teacherId);
        //按照最后更新时间倒序排列
        queryWrapper.orderByDesc("gmt_modified");

        List<EduCourse> courses = baseMapper.selectList(queryWrapper);
        return courses;
    }

    @Override
    public Map<String, Object> pageListWeb(Page<EduCourse> pageParam, CourseQueryVo courseQuery) {
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseQuery.getSubjectParentId())) {
            queryWrapper.eq("subject_parent_id", courseQuery.getSubjectParentId());
        }

        if (!StringUtils.isEmpty(courseQuery.getSubjectId())) {
            queryWrapper.eq("subject_id", courseQuery.getSubjectId());
        }

        if (!StringUtils.isEmpty(courseQuery.getBuyCountSort())) {
            queryWrapper.orderByDesc("buy_count");
        }

        if (!StringUtils.isEmpty(courseQuery.getGmtCreateSort())) {
            queryWrapper.orderByDesc("gmt_create");
        }

        if (!StringUtils.isEmpty(courseQuery.getPriceSort())) {
            queryWrapper.orderByDesc("price");
        }

        baseMapper.selectPage(pageParam, queryWrapper);

        List<EduCourse> records = pageParam.getRecords();
        long current = pageParam.getCurrent();
        long pages = pageParam.getPages();
        long size = pageParam.getSize();
        long total = pageParam.getTotal();
        boolean hasNext = pageParam.hasNext();
        boolean hasPrevious = pageParam.hasPrevious();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);

        return map;
    }

    @Override
    public CourseWebVo selectInfoWebById(String id) {
        this.updatePageViewCount(id);
        return baseMapper.selectInfoWebById(id);
    }

    @Override
    public void updatePageViewCount(String id) {
        EduCourse course = baseMapper.selectById(id);
        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);
    }
}
