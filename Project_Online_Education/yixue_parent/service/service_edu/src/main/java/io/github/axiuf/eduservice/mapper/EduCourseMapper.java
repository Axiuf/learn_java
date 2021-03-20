package io.github.axiuf.eduservice.mapper;

import io.github.axiuf.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.axiuf.eduservice.entity.frontvo.CourseWebVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getPublishCourseInfo(String courseId);

    CourseWebVo selectInfoWebById(String courseId);
}
