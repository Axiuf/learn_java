package io.github.axiuf.eduservice.service.impl;

import io.github.axiuf.eduservice.entity.EduCourse;
import io.github.axiuf.eduservice.entity.EduCourseDescription;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;
import io.github.axiuf.eduservice.mapper.EduCourseMapper;
import io.github.axiuf.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
}
