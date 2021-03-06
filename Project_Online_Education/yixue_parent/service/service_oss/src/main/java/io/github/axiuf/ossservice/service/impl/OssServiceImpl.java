package io.github.axiuf.ossservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import io.github.axiuf.ossservice.service.OssService;
import io.github.axiuf.ossservice.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */
@Service
public class OssServiceImpl implements OssService
{
    @Override
    public String uploadFileAvatar(MultipartFile file)
    {

        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try
        {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String datePath = new DateTime().toString("yyyy/MM/dd");

            String filePath = datePath + "/" + uuid + fileName;

            // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(bucketName, filePath, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            // https://yixue-axiuf.oss-cn-hangzhou.aliyuncs.com/

            return "https://" + bucketName + "." + endpoint + "/" + filePath;
        }
        catch (IOException e)
        {
            e.printStackTrace();

            return null;
        }
    }
}
