package io.github.axiuf.eduservice.service;

import io.github.axiuf.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
