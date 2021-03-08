package io.github.axiuf.eduservice.controller;


import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduVideo;
import io.github.axiuf.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {
    private EduVideoService eduVideoService;

    @Autowired
    public void setEduVideoService(EduVideoService eduVideoService)
    {
        this.eduVideoService = eduVideoService;
    }

    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo)
    {
        eduVideoService.save(eduVideo);

        return R.ok();
    }

    // 后续要补充删除小节的时候删除对应的视频
    @DeleteMapping("/deleteVideo/{id}")
    public R deleteVideo(@PathVariable String id)
    {
        eduVideoService.removeById(id);

        return R.ok();
    }
}

