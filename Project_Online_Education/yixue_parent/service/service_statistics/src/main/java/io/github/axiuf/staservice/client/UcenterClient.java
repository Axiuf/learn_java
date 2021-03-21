package io.github.axiuf.staservice.client;

import io.github.axiuf.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Shan Cheng
 * @since 2021/3/21
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    @GetMapping(value = "/ucenterservice/apimember/countregister/{day}")
    public R registerCount(@PathVariable("day") String day);
}
