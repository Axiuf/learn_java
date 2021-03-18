package io.github.axiuf.educms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.educms.entity.CrmBanner;
import io.github.axiuf.educms.mapper.CrmBannerMapper;
import io.github.axiuf.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-12
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner()
    {
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 2");

        return baseMapper.selectList(wrapper);
    }
}
