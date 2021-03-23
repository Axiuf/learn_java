package io.github.axiuf.eduservice.controller;


import com.mysql.cj.util.StringUtils;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.client.VodClient;
import io.github.axiuf.eduservice.entity.EduVideo;
import io.github.axiuf.eduservice.service.EduVideoService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
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

@RequestMapping("/eduservice/edu-video")
public class EduVideoController {
    private EduVideoService eduVideoService;
    private VodClient vodClient;

    @Autowired
    public void setVodClient(VodClient vodClient)
    {
        this.vodClient = vodClient;
    }

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

    @DeleteMapping("/deleteVideo/{id}")
    public R deleteVideo(@PathVariable String id)
    {

        EduVideo eduVideo = eduVideoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();

        if (!StringUtils.isNullOrEmpty(videoSourceId)){
            R result = vodClient.removeAliVideo(videoSourceId);
            if(result.getCode() == 20001)
            {
                throw new YixueException(20001, "删除视频失败");
            }
        }

        eduVideoService.removeById(id);
        return R.ok();
    }
}

