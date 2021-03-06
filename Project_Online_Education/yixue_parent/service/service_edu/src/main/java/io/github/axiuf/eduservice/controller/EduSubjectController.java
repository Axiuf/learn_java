package io.github.axiuf.eduservice.controller;


import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.subject.PrimarySubject;
import io.github.axiuf.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/eduservice/edu-subject")
@CrossOrigin
public class EduSubjectController {
    private EduSubjectService eduSubjectService;

    @Autowired
    public void setEduSubjectService(EduSubjectService eduSubjectService)
    {
        this.eduSubjectService = eduSubjectService;
    }

    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file)
    {
        eduSubjectService.saveSubject(file, eduSubjectService);
        return R.ok();
    }

    @GetMapping("/getAllSubjects")
    public R getAllSubjects()
    {
        List<PrimarySubject> list = eduSubjectService.getAllSubjects();

        return R.ok();
    }
}

