package io.github.axiuf.educms.controller;

import io.github.axiuf.commonutils.R;
import io.github.axiuf.educms.entity.CrmBanner;
import io.github.axiuf.educms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/12
 */

@RestController
@RequestMapping("/educms/banner-front")
@Api(description = "网站首页Banner列表")
 //跨域
public class BannerFrontController {

    private CrmBannerService bannerService;

    @Autowired
    public void setBannerService(CrmBannerService bannerService)
    {
        this.bannerService = bannerService;
    }

    @ApiOperation(value = "获取首页banner")
    @GetMapping("/getAllBanner")
    public R index() {
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("bannerList", list);
    }

}
