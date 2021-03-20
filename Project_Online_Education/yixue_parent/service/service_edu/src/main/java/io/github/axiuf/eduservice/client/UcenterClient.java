package io.github.axiuf.eduservice.client;

import io.github.axiuf.eduservice.entity.UcenterMemberPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Shan Cheng
 * @since 2021/3/19
 */
@Component
@FeignClient(name="service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {

    //根据用户id获取用户信息
    @GetMapping("/ucenterservice/apimember/getInfoUc/{memberId}")
    UcenterMemberPay getUcenterPay(@PathVariable("memberId") String memberId);
}
