package com.cp.auth.application.controller;

import com.cp.auth.application.convert.AuthRolePermissionDtoConvert;
import com.cp.auth.application.dto.AuthRolePermissionDto;
import com.cp.auth.common.entity.Result;
import com.cp.auth.domain.bo.AuthRolePermissionBo;
import com.cp.auth.domain.service.AuthRolePermissionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色权限关联controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/28 上午10:39
 **/
@RestController
@RequestMapping("/rolePermission/")
@Slf4j
public class AuthRolePermissionController {

    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;

    /**|
     * 添加角色权限关联
     * @param authRolePermissionDto
     * @return
     */
    @PostMapping("addAuthRolePermission")
    public Result<Boolean> addAuthRolePermission(@RequestBody AuthRolePermissionDto authRolePermissionDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthRolePermissionController.addAuthRolePermission authRolePermissionDto: {}", authRolePermissionDto);
            }
            Preconditions.checkNotNull(authRolePermissionDto.getRoleId(),"角色不能为空");
            Preconditions.checkNotNull(CollectionUtils.isEmpty(authRolePermissionDto.getPermissionIdList()),"权限不能为空");
            AuthRolePermissionBo authRolePermissionBo = AuthRolePermissionDtoConvert.INSTANCE.convertDtoToBo(authRolePermissionDto);
            return Result.ok(authRolePermissionDomainService.addRolePermission(authRolePermissionBo));
        }catch (Exception e){
            log.info("AuthRolePermissionController.addAuthRolePermission error:{}",e.getMessage(),e);
            return Result.fail("添加角色权限失败");
        }
    }
}
