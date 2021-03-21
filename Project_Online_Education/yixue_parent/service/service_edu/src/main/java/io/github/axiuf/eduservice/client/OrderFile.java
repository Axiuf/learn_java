package io.github.axiuf.eduservice.client;

import org.springframework.stereotype.Component;

/**
 * @author Shan Cheng
 * @since 2021/3/21
 */
@Component
public class OrderFile implements OrderClient
{
    @Override
    public boolean isBuyCourse(String memberid, String id)
    {
        return false;
    }
}
