package io.github.axiuf.eduorder.client;

import io.github.axiuf.commonutils.CourseInfoForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Shan Cheng
 * @since 2021/3/20
 */
@Component
@FeignClient("service-edu")
public interface EduClient {
    //根据课程id查询课程信息
    @GetMapping("/eduservice/coursefront/getDto/{courseId}")
    public CourseInfoForm getCourseInfoDto(@PathVariable("courseId") String courseId);
}