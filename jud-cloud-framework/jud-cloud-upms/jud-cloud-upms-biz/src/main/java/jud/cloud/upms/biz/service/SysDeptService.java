package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.upms.api.dto.DeptTree;
import jud.cloud.upms.api.entity.SysDept;

import java.util.List;

/**
 * 部门管理
 */
public interface SysDeptService extends IService<SysDept> {
    /**
     * 查询部门树菜单
     *
     * @return 树
     */
    List<DeptTree> selectTree();

    /**
     * 查询用户部门树
     *
     * @return
     */
    List<DeptTree> getUserTree();

    /**
     * 添加信息部门
     *
     * @param sysDept
     * @return
     */
    Boolean saveDept(SysDept sysDept);

    /**
     * 删除部门
     *
     * @param id 部门 ID
     * @return 成功、失败
     */
    Boolean removeDeptById(Integer id);

    /**
     * 更新部门
     *
     * @param sysDept 部门信息
     * @return 成功、失败
     */
    Boolean updateDeptById(SysDept sysDept);
}
