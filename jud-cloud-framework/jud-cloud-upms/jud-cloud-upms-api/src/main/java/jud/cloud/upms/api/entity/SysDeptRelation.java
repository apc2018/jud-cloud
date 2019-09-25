package jud.cloud.upms.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门关系表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept_relation")
public class SysDeptRelation extends Model<SysDeptRelation> {
    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
    private Integer ancestor;
    /**
     * 后代节点
     */
    private Integer descendant;
}
