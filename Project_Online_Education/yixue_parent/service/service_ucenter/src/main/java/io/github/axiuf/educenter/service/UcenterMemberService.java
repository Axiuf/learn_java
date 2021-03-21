package io.github.axiuf.educenter.service;

import io.github.axiuf.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.axiuf.educenter.entity.vo.LoginVo;
import io.github.axiuf.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-15
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(LoginVo loginVo);

    void register(RegisterVo registerVo);

    UcenterMember  getLoginInfo(String memberId);

    UcenterMember getByOpenid(String openid);

    Integer countRegisterByDay(String day);
}
