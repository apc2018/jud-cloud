package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.entity.SysMenu;
import jud.cloud.upms.api.vo.MenuVO;

import java.util.List;

/**
 * 系统菜单管理
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 通过角色编号查询URL 权限
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleId(Integer roleId);

    /**
     * 级联删除菜单
     *
     * @param id 菜单ID
     * @return 成功、失败
     */
    R removeMenuById(Integer id);

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @return 成功、失败
     */
    Boolean updateMenuById(SysMenu sysMenu);
}
