package io.github.axiuf.eduservice.client;

import io.github.axiuf.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/10
 */

@Component
public class VodFileDegradeFeignClient implements VodClient
{
    @Override
    public R removeAliVideo(String id)
    {
        return R.error().message("删除视频出错了");
    }

    @Override
    public R deleteBatch(List<String> videoList)
    {
        return R.error().message("删除多个视频出错了");
    }
}
