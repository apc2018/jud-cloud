package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.upms.api.entity.SysDept;
import jud.cloud.upms.api.entity.SysDeptRelation;

public interface SysDeptRelationService extends IService<SysDeptRelation> {
    /**
     * 新建部门关系
     *
     * @param sysDept 部门
     */
    void insertDeptRelation(SysDept sysDept);

    /**
     * 通过ID删除部门关系
     *
     * @param id
     */
    void deleteAllDeptRealtion(Integer id);

    /**
     * 更新部门关系
     *
     * @param relation
     */
    void updateDeptRealtion(SysDeptRelation relation);
}
