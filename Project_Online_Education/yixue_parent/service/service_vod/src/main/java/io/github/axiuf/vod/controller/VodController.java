package io.github.axiuf.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import io.github.axiuf.vod.service.VodService;
import io.github.axiuf.vod.utils.ConstantVodUtils;
import io.github.axiuf.vod.utils.InitVodClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/9
 */

@Api(description="阿里云视频点播微服务")
@RestController
@RequestMapping("/eduvod/video")

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

    @GetMapping("/get-play-auth/{videoId}")
    public R getVideoPlayAuth(@PathVariable("videoId") String videoId) throws Exception {

        //获取阿里云存储相关常量
        String accessKeyId = ConstantVodUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantVodUtils.ACCESS_KEY_SECRET;

        //初始化
        DefaultAcsClient client = InitVodClient.initVodClient(accessKeyId, accessKeySecret);

        //请求
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);

        //响应
        GetVideoPlayAuthResponse response = client.getAcsResponse(request);

        //得到播放凭证
        String playAuth = response.getPlayAuth();

        //返回结果
        return R.ok().message("获取凭证成功").data("playAuth", playAuth);
    }
}
