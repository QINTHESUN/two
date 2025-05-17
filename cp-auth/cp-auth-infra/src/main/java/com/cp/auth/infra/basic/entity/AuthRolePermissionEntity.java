package com.cp.auth.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 角色权限关联表(AuthRolePermission)表实体类
 * 
 * @author makejava
 * @since 2024-10-28 10:28:59
 */

@Data
@TableName("auth_role_permission")
public class AuthRolePermissionEntity  implements Serializable {
    private static final long serialVersionUID = 467799318323121337L;

    /**
     * 
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDeleted;

}

