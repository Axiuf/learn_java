package io.github.axiuf.eduservice.service;

import io.github.axiuf.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.axiuf.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterByCourse(String courseId);

    boolean deleteChapter(String id);

    void removeChapterByCourseId(String id);
}
