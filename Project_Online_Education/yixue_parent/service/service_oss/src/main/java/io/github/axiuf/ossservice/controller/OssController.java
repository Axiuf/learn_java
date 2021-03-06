package io.github.axiuf.ossservice.controller;

import io.github.axiuf.commonutils.R;
import io.github.axiuf.ossservice.service.impl.OssServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController
{
    private OssServiceImpl ossService;

    @Autowired
    public void setOssService(OssServiceImpl ossService)
    {
        this.ossService = ossService;
    }

    @PostMapping
    public R uploadOssFile(MultipartFile file)
    {
        String url = ossService.uploadFileAvatar(file);

        return R.ok().data("url", url);
    }
}
