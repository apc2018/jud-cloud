package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.upms.api.entity.SysOauthClientDetails;

public interface SysOauthClientDetailsService extends IService<SysOauthClientDetails> {
    /**
     * 通过ID删除客户端
     *
     * @param id
     * @return
     */
    Boolean removeClientDetailsById(String id);

    /**
     * 根据客户端信息
     *
     * @param sysOauthClientDetails
     * @return
     */
    Boolean updateClientDetailsById(SysOauthClientDetails sysOauthClientDetails);
}
