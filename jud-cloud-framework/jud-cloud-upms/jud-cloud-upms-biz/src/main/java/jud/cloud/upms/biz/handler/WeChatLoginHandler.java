package jud.cloud.upms.biz.handler;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.core.constant.enums.LoginTypeEnum;
import jud.cloud.upms.api.dto.UserInfo;
import jud.cloud.upms.api.entity.SysSocialDetails;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.biz.mapper.SysSocialDetailsMapper;
import jud.cloud.upms.biz.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component("WX")
@AllArgsConstructor
public class WeChatLoginHandler extends AbstractLoginHandler {

    private final RestTemplate restTemplate;
    private final SysUserService sysUserService;
    private final SysSocialDetailsMapper sysSocialDetailsMapper;

    /**
     * 微信登录传入code
     * <p>
     * 通过code 调用qq 获取唯一标识
     *
     * @param code
     * @return
     */
    @Override
    public String identify(String code) {
        SysSocialDetails condition = new SysSocialDetails();
        condition.setType(LoginTypeEnum.WECHAT.getType());
        SysSocialDetails socialDetails = sysSocialDetailsMapper.selectOne(new QueryWrapper<>(condition));

        String url = String.format(SecurityConstants.WX_AUTHORIZATION_CODE_URL
                , socialDetails.getAppId(), socialDetails.getAppSecret(), code);
        String result = restTemplate.getForObject(url, String.class);
        log.debug("微信响应报文:{}", result);

        Object obj = JSONUtil.parseObj(result).get("openid");
        return obj.toString();
    }

    /**
     * openId 获取用户信息
     *
     * @param openId
     * @return
     */
    @Override
    public UserInfo info(String openId) {
        SysUser user = sysUserService
                .getOne(Wrappers.<SysUser>query()
                        .lambda().eq(SysUser::getWxOpenid, openId));

        if (user == null) {
            log.info("微信未绑定:{}", openId);
            return null;
        }
        return sysUserService.findUserInfo(user);
    }
}
