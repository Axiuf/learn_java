package io.github.axiuf.eduservice.client;

import io.github.axiuf.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/10
 */

@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class)
@Component
public interface VodClient
{
    @DeleteMapping("/eduvod/video/removeAliVideo/{id}")
    public R removeAliVideo(@PathVariable("id") String id);

    @DeleteMapping("/eduvod/video/deleteBatch")
    public R deleteBatch(@RequestParam("videoList") List<String> videoList);
}
