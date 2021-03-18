package io.github.axiuf.educenter.controller;


import io.github.axiuf.commonutils.JwtUtils;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.educenter.entity.UcenterMember;
import io.github.axiuf.educenter.entity.vo.LoginVo;
import io.github.axiuf.educenter.entity.vo.RegisterVo;
import io.github.axiuf.educenter.service.UcenterMemberService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-15
 */
@RestController
@RequestMapping("/ucenterservice/apimember")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation(value = "会员登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo) {
        String token = memberService.login(loginVo);
        return R.ok().data("token", token);
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return R.ok();
    }

    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("/auth/getLoginInfo")
    public R getLoginInfo(HttpServletRequest request){
        try {
            String memberId = JwtUtils.getMemberIdByJwtToken(request);
            UcenterMember member = memberService.getLoginInfo(memberId);
            return R.ok().data("item", member);
        }catch (Exception e){
            e.printStackTrace();
            throw new YixueException(20001,"error");
        }
    }
}

