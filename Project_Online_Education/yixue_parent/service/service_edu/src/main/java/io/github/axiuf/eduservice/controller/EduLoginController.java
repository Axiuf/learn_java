package io.github.axiuf.eduservice.controller;

import io.github.axiuf.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shan Cheng
 * @date 2021/3/4
 */

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController
{
    @PostMapping("/login")
    public R login()
    {
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R info()
    {
        return R.ok().data("roles", "[admin]").data("name", "admin")
                .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
