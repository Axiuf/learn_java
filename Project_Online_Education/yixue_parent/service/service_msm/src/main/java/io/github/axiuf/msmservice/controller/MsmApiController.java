package io.github.axiuf.msmservice.controller;

import io.github.axiuf.commonutils.R;
import io.github.axiuf.msmservice.service.MsmService;
import io.github.axiuf.msmservice.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Shan Cheng
 * @since 2021/3/14
 */
@RestController
@RequestMapping("/edumsm/msm")
 //跨域
public class MsmApiController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/send/{phone}")
    public R code(@PathVariable String phone) {
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)) return R.ok();

        // 阿里云短信不向个人开放了，这里手动写死做测试用
        // code = RandomUtil.getFourBitRandom();
        code = "1234";
        Map<String,Object> param = new HashMap<>();
        param.put("code", code);
        // boolean isSend = msmService.send(phone, "SMS_213086549", param);
        boolean isSend = true;
        if(isSend) {
            redisTemplate.opsForValue().set(phone, code,5, TimeUnit.MINUTES);
            return R.ok();
        } else {
            return R.error().message("发送短信失败");
        }
    }
}