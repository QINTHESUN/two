package com.cp.auth.infra.basic.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户角色表(AuthUserRole)表实体类
 * 
 * @author makejava
 * @since 2024-10-30 13:27:17
 */

@Data
@TableName("auth_user_role")
public class AuthUserRoleEntity  implements Serializable {
    private static final long serialVersionUID = -73903344756242917L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

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

