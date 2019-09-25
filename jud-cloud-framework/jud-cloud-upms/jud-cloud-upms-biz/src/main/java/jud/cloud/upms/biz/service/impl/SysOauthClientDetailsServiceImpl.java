package jud.cloud.upms.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.upms.api.entity.SysOauthClientDetails;
import jud.cloud.upms.biz.mapper.SysOauthClientDetailsMapper;
import jud.cloud.upms.biz.service.SysOauthClientDetailsService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements SysOauthClientDetailsService {
    /**
     * 通过ID删除客户端
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#id")
    public Boolean removeClientDetailsById(String id) {
        return this.removeById(id);
    }

    /**
     * 根据客户端信息
     *
     * @param clientDetails
     * @return
     */
    @Override
    @CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#clientDetails.clientId")
    public Boolean updateClientDetailsById(SysOauthClientDetails clientDetails) {
        return this.updateById(clientDetails);
    }
}
