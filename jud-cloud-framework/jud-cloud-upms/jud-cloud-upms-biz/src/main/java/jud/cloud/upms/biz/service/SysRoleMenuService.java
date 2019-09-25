package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.upms.api.entity.SysRoleMenu;

public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 更新角色菜单
     *
     * @param role
     * @param roleId  角色
     * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
     * @return
     */
    Boolean saveRoleMenus(String role, Integer roleId, String menuIds);
}
