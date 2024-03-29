package jud.cloud.upms.biz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jud.cloud.common.core.constant.CommonConstants;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.core.constant.enums.LoginTypeEnum;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.biz.mapper.SysUserMapper;
import jud.cloud.upms.biz.service.MobileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 手机登陆服务
 */
@Slf4j
@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {
    private final RedisTemplate redisTemplate;
    private final SysUserMapper userMapper;


    /**
     * 发送手机验证码
     * TODO: 调用短信网关发送验证码,测试返回前端
     *
     * @param mobile mobile
     * @return code
     */
    @Override
    public R<Boolean> sendSmsCode(String mobile) {
        List<SysUser> userList = userMapper.selectList(Wrappers
                .<SysUser>query().lambda()
                .eq(SysUser::getPhone, mobile));

        if (CollUtil.isEmpty(userList)) {
            log.info("手机号未注册:{}", mobile);
            return new R<>(Boolean.FALSE, "手机号未注册");
        }

        Object codeObj = redisTemplate.opsForValue().get(CommonConstants.DEFAULT_CODE_KEY + mobile);

        if (codeObj != null) {
            log.info("手机号验证码未过期:{}，{}", mobile, codeObj);
            return new R<>(Boolean.FALSE, "手机号未注册");
        }

        String code = RandomUtil.randomNumbers(Integer.parseInt(SecurityConstants.CODE_SIZE));
        log.debug("手机号生成验证码成功:{},{}", mobile, code);
        redisTemplate.opsForValue().set(
                CommonConstants.DEFAULT_CODE_KEY + LoginTypeEnum.SMS.getType() + "@" + mobile
                , code, SecurityConstants.CODE_TIME, TimeUnit.SECONDS);
        return new R<>(Boolean.TRUE, code);
    }
}
