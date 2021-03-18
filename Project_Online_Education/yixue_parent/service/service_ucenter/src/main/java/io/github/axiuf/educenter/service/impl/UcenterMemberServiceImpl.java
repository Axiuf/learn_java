package io.github.axiuf.educenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.commonutils.JwtUtils;
import io.github.axiuf.commonutils.MD5;
import io.github.axiuf.educenter.entity.UcenterMember;
import io.github.axiuf.educenter.entity.vo.LoginVo;
import io.github.axiuf.educenter.entity.vo.RegisterVo;
import io.github.axiuf.educenter.mapper.UcenterMemberMapper;
import io.github.axiuf.educenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-15
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 会员登录
     * @param loginVo
     * @return
     */
    @Override
    public String login(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        //校验参数
        if(StringUtils.isEmpty(mobile) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(mobile)) {
            throw new YixueException(20001,"error");
        }

        //获取会员
        UcenterMember member = baseMapper.selectOne(new QueryWrapper<UcenterMember>().eq("mobile", mobile));
        if(null == member) {
            throw new YixueException(20001,"error");
        }

        //校验密码
        if(!MD5.encrypt(password).equals(member.getPassword())) {
            throw new YixueException(20001,"error");
        }

        //校验是否被禁用
        if(member.getIsDisabled()) {
            throw new YixueException(20001,"error");
        }

        //使用JWT生成token字符串
        String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        return token;
    }

    /**
     * 会员注册
     * @param registerVo
     */
    @Override
    public void register(RegisterVo registerVo) {
        //获取注册信息，进行校验
        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String code = registerVo.getCode();

        //校验参数
        if(StringUtils.isEmpty(mobile) ||
                StringUtils.isEmpty(mobile) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(code)) {
            throw new YixueException(20001,"error");
        }

        //校验校验验证码
        //从redis获取发送的验证码
        String mobleCode = redisTemplate.opsForValue().get(mobile);
        if(!code.equals(mobleCode)) {
            throw new YixueException(20001,"error");
        }

        //查询数据库中是否存在相同的手机号码
        Integer count = baseMapper.selectCount(new QueryWrapper<UcenterMember>().eq("mobile", mobile));
        if(count.intValue() > 0) {
            throw new YixueException(20001,"error");
        }

        //添加注册信息到数据库
        UcenterMember member = new UcenterMember();
        member.setNickname(nickname);
        member.setMobile(registerVo.getMobile());
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        this.save(member);
    }

    @Override
    public UcenterMember getLoginInfo(String memberId) {
        UcenterMember member = baseMapper.selectById(memberId);
        // LoginVo loginInfoVo = new LoginVo();
        // BeanUtils.copyProperties(member, loginInfoVo);
        return member;
    }

    @Override
    public UcenterMember getByOpenid(String openid)
    {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", openid);
        return baseMapper.selectOne(wrapper);
    }
}