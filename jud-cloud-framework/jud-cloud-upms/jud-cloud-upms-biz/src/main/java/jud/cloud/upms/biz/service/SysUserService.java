package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.dto.UserDTO;
import jud.cloud.upms.api.dto.UserInfo;
import jud.cloud.upms.api.entity.SysUser;
import jud.cloud.upms.api.vo.UserVO;

import java.util.List;

public interface SysUserService extends IService<SysUser> {
    /**
     * 查询用户信息
     *
     * @param sysUser 用户
     * @return userInfo
     */
    UserInfo findUserInfo(SysUser sysUser);

    /**
     * 分页查询用户信息（含有角色信息）
     *
     * @param page    分页对象
     * @param userDTO 参数列表
     * @return
     */
    IPage getUsersWithRolePage(Page page, UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param sysUser 用户
     * @return boolean
     */
    Boolean deleteUserById(SysUser sysUser);

    /**
     * 更新当前用户基本信息
     *
     * @param userDto 用户信息
     * @return Boolean
     */
    R<Boolean> updateUserInfo(UserDTO userDto);

    /**
     * 更新指定用户信息
     *
     * @param userDto 用户信息
     * @return
     */
    Boolean updateUser(UserDTO userDto);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserVO selectUserVoById(Integer id);

    /**
     * 查询上级部门的用户信息
     *
     * @param username 用户名
     * @return R
     */
    List<SysUser> listAncestorUsers(String username);

    /**
     * 保存用户信息
     *
     * @param userDto DTO 对象
     * @return success/fail
     */
    Boolean saveUser(UserDTO userDto);
}
