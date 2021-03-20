package io.github.axiuf.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.axiuf.eduservice.entity.frontvo.CourseQueryVo;
import io.github.axiuf.eduservice.entity.frontvo.CourseWebVo;
import io.github.axiuf.eduservice.entity.vo.CourseInfoVo;
import io.github.axiuf.eduservice.entity.vo.CoursePublishVo;

import java.util.List;
import java.util.Map;

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

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourseInfo(String id);

    List<EduCourse> selectByTeacherId(String id);

    Map<String, Object> pageListWeb(Page<EduCourse> pageParam, CourseQueryVo courseQuery);

    /**
     * 获取课程信息
     * @param id
     * @return
     */
    CourseWebVo selectInfoWebById(String id);

    /**
     * 更新课程浏览数
     * @param id
     */
    void updatePageViewCount(String id);
}
