package jud.cloud.common.security.util;

import cn.hutool.core.util.StrUtil;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.security.service.JudCloudUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 安全工具类
 */
@UtilityClass
public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     *
     * @param authentication
     * @return JudCloudUser
     * <p>
     * 获取当前用户的全部信息 EnableJudCloudResourceServer true
     * 获取当前用户的用户名 EnableJudCloudResourceServer false
     */
    public JudCloudUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof JudCloudUser) {
            return (JudCloudUser) principal;
        }
        return null;
    }

    /**
     * 获取当前用名
     *
     * @return String
     */
    public String getUsername() {
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof String) {
            return principal.toString();
        }
        return null;
    }


    public String getClientId() {
        Authentication authentication = getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            return auth2Authentication.getOAuth2Request().getClientId();
        }
        return null;
    }

    /**
     * 获取用户
     */
    public JudCloudUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public List<Integer> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<Integer> roleIds = new ArrayList<>();
        authorities.stream()
                .filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstants.ROLE))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), SecurityConstants.ROLE);
                    roleIds.add(Integer.parseInt(id));
                });
        return roleIds;
    }
}
