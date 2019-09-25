package jud.cloud.upms.biz.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jud.cloud.upms.api.dto.UserInfo;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.biz.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("SMS")
@AllArgsConstructor
public class SmsLoginHandler extends AbstractLoginHandler {
    private final SysUserService sysUserService;

    /**
     * 验证码登录传入为手机号
     * 不用不处理
     *
     * @param mobile
     * @return
     */
    @Override
    public String identify(String mobile) {
        return mobile;
    }

    /**
     * 通过mobile 获取用户信息
     *
     * @param identify
     * @return
     */
    @Override
    public UserInfo info(String identify) {
        SysUser user = sysUserService
                .getOne(Wrappers.<SysUser>query()
                        .lambda().eq(SysUser::getPhone, identify));

        if (user == null) {
            log.info("手机号未注册:{}", identify);
            return null;
        }
        return sysUserService.findUserInfo(user);
    }
}
