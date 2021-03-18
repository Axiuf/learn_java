package io.github.axiuf.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @since 2021/3/9
 */

@Component
public class ConstantVodUtils implements InitializingBean
{
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        ACCESS_KEY_ID = this.keyId;

        ACCESS_KEY_SECRET = this.keySecret;
    }
}
