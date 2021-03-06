package io.github.axiuf.eduservice.service;

import io.github.axiuf.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.axiuf.eduservice.entity.subject.PrimarySubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-05
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);

    List<PrimarySubject> getAllSubjects();
}
