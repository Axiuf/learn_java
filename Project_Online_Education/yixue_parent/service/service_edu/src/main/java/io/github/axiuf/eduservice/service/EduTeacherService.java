package io.github.axiuf.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-01
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String,Object> pageListWeb(Page<EduTeacher> pageParam);
}
