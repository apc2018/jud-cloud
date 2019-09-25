package jud.cloud.common.security.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import jud.cloud.common.core.constant.CommonConstants;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.dto.UserInfo;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.api.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户详细信息
 */
@Slf4j
@Service
@AllArgsConstructor
public class JudCloudUserDetailsServiceImpl implements JudCloudUserDetailsService {
    private final RemoteUserService remoteUserService;
    private final CacheManager cacheManager;

    /**
     * 用户密码登录
     *
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cache cache = cacheManager.getCache("user_details");
        if (cache != null && cache.get(username) != null) {
            return (JudCloudUser) cache.get(username).get();
        }

        R<UserInfo> result = remoteUserService.info(username, SecurityConstants.FROM_IN);
        UserDetails userDetails = getUserDetails(result);
        cache.put(username, userDetails);
        return userDetails;
    }


    /**
     * 根据社交登录code 登录
     *
     * @param inStr TYPE@CODE
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserBySocial(String inStr) throws UsernameNotFoundException {
        return getUserDetails(remoteUserService.social(inStr, SecurityConstants.FROM_IN));
    }

    /**
     * 构建userdetails
     *
     * @param result 用户信息
     * @return
     */
    private UserDetails getUserDetails(R<UserInfo> result) {
        if (result == null || result.getData() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        UserInfo info = result.getData();
        Set<String> dbAuthsSet = new HashSet<>();
        if (ArrayUtil.isNotEmpty(info.getRoles())) {
            // 获取角色
            Arrays.stream(info.getRoles()).forEach(roleId -> dbAuthsSet.add(SecurityConstants.ROLE + roleId));
            // 获取资源
            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));

        }
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));
        SysUser user = info.getSysUser();
        boolean enabled = StrUtil.equals(user.getLockFlag(), CommonConstants.STATUS_NORMAL);
        // 构造security用户

        return new JudCloudUser(user.getUserId(), user.getDeptId(), user.getTenantId(), user.getUsername(), SecurityConstants.BCRYPT + user.getPassword(), enabled,
                true, true, !CommonConstants.STATUS_LOCK.equals(user.getLockFlag()), authorities);
    }
}
