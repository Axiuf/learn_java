package io.github.axiuf.eduorder.client;

import io.github.axiuf.commonutils.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Shan Cheng
 * @since 2021/3/20
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    //根据课程id查询课程信息
    @PostMapping("/ucenterservice/apimember/getInfoUcOrder/{id}")
    public UcenterMemberOrder getInfo(@PathVariable("id") String id);
}