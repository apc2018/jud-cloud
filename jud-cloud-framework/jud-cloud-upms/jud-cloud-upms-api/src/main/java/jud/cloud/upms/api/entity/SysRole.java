package jud.cloud.upms.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统角色
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
// @KeySequence(value = "SEQ_SYSROLE", clazz = Integer.class)
public class SysRole extends Model<SysRole> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roleSeq")
//    @SequenceGenerator(name = "roleSeq", initialValue = 1, allocationSize = 1, sequenceName = "ROLE_SEQUENCE")
    private Integer roleId;

    @NotBlank(message = "角色名称 不能为空")
    private String roleName;

    @NotBlank(message = "角色标识 不能为空")
    private String roleCode;

    @NotBlank(message = "角色描述 不能为空")
    private String roleDesc;

    @NotNull(message = "数据权限类型 不能为空")
    private Integer dsType;

    private String dsScope;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableLogic
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
