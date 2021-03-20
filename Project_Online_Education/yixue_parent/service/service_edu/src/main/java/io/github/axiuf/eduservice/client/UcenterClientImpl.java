package io.github.axiuf.eduservice.client;

import io.github.axiuf.eduservice.entity.UcenterMemberPay;
import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @since 2021/3/19
 */
@Component
public class UcenterClientImpl implements UcenterClient {
    @Override
    public UcenterMemberPay getUcenterPay(String memberId) {
        return null;
    }
}
