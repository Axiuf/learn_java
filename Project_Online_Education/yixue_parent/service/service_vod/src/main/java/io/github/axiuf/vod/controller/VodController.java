package io.github.axiuf.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import io.github.axiuf.vod.service.VodService;
import io.github.axiuf.vod.utils.ConstantVodUtils;
import io.github.axiuf.vod.utils.InitVodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/9
 */

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController
{
    private VodService vodService;

    @Autowired
    public void setVodService(VodService vodService)
    {
        this.vodService = vodService;
    }

    @PostMapping("/uploadAliVideo")
    public R uploadAliVideo(MultipartFile file)
    {
        String videoId = vodService.uploadAliVideo(file);
        return R.ok().data("videoId", videoId);
    }

    @DeleteMapping("/removeAliVideo/{id}")
    public R removeAliVideo(@PathVariable String id)
    {
        try
        {
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();

            request.setVideoIds(id);

            client.getAcsResponse(request);

            return R.ok();
        }
        catch (ClientException e)
        {
            e.printStackTrace();
            throw new YixueException(20001, "删除视频失败");
        }
    }

    @DeleteMapping("/deleteBatch")
    public R deleteBatch(@RequestParam("videoList") List<String> videoList) {
        vodService.removeBatchAliVideo(videoList);

        return R.ok();
    }
}
