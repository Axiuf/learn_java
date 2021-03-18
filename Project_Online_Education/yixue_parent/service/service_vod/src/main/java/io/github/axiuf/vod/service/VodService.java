package io.github.axiuf.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/9
 */
public interface VodService
{
    String uploadAliVideo(MultipartFile file);

    void removeBatchAliVideo(List videoList);
}
