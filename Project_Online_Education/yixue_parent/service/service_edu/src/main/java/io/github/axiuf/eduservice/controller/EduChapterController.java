package io.github.axiuf.eduservice.controller;


import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduChapter;
import io.github.axiuf.eduservice.entity.chapter.ChapterVo;
import io.github.axiuf.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */

@RestController
@RequestMapping("/eduservice/edu-chapter")
public class EduChapterController {
    private EduChapterService chapterService;

    @Autowired
    public void setChapterService(EduChapterService chapterService)
    {
        this.chapterService = chapterService;
    }

    @GetMapping("/getChapterVideo/{courseId}")
    public R getAllChapter(@PathVariable String courseId)
    {
        List<ChapterVo> list = chapterService.getChapterByCourse(courseId);

        return R.ok().data("allChapterVideo", list);
    }

    @PostMapping("/addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter)
    {
        chapterService.save(eduChapter);

        return R.ok();
    }

    @GetMapping("/getChapterById/{id}")
    public R getChapterById(@PathVariable String id)
    {
        EduChapter eduChapter = chapterService.getById(id);

        return R.ok().data("chapterInfo", eduChapter);
    }

    @PostMapping("/updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter)
    {
        chapterService.updateById(eduChapter);

        return R.ok();
    }

    @DeleteMapping("/deleteChapter/{id}")
    public R deleteChapter(@PathVariable String id)
    {
        boolean result = chapterService.deleteChapter(id);

        return R.ok();
    }

}

