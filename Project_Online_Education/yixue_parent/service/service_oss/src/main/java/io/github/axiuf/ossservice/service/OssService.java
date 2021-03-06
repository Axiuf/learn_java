package io.github.axiuf.ossservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */
public interface OssService
{
    String uploadFileAvatar(MultipartFile file);
}
