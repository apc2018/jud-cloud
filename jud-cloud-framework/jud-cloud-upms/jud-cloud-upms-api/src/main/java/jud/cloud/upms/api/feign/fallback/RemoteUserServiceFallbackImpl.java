package jud.cloud.upms.api.feign.fallback;

import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.dto.UserInfo;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.api.feign.RemoteUserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

    @Setter
    private Throwable cause;

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @param from     内外标志
     * @return R
     */
    @Override
    public R<UserInfo> info(String username, String from) {
        log.error("feign 查询用户信息失败:{}", username, cause);
        return null;
    }

    /**
     * 通过社交账号查询用户、角色信息
     *
     * @param inStr appid@code
     * @param from  内外标志
     * @return
     */
    @Override
    public R<UserInfo> social(String inStr, String from) {
        log.error("feign 查询用户信息失败:{}", inStr, cause);
        return null;
    }

    /**
     * 查询上级部门的用户信息
     *
     * @param username 用户名
     * @return R
     */
    @Override
    public R<List<SysUser>> ancestorUsers(String username) {
        log.error("feign 查询用户上级部门用户列失败:{}", username, cause);
        return null;
    }
}
