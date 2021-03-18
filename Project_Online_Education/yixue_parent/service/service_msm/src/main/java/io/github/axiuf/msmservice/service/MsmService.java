package io.github.axiuf.msmservice.service;

import java.util.Map;

/**
 * @author Shan Cheng
 * @since 2021/3/14
 */
public interface MsmService
{
    boolean send(String PhoneNumbers, String templateCode, Map<String,Object> param);
}
