package com.cp.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.auth.application.convert.AuthRoleDtoConvert;
import com.cp.auth.application.dto.AuthRoleDto;
import com.cp.auth.common.entity.Result;
import com.cp.auth.domain.bo.AuthRoleBo;
import com.cp.auth.domain.service.AuthRoleDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/26 上午9:32
 **/
@RestController
@RequestMapping("/role/")
@Slf4j
public class AuthRoleController {

    @Resource
    private AuthRoleDomainService authRoleDomainService;


    /**
     * 添加角色
     * @param authRoleDto
     * @return
     */
    @PostMapping("add")
    public Result<Boolean> addRole(@RequestBody AuthRoleDto authRoleDto){
        try{
            if (log.isInfoEnabled()){
                log.info("AuthRoleController.addRole: authRoleDto={}", JSON.toJSONString(authRoleDto));
            }
            Preconditions.checkNotNull(authRoleDto.getRoleName(),"角色名称不能为空");
            Preconditions.checkNotNull(authRoleDto.getRoleKey(),"角色唯一标识不能为空");
            AuthRoleBo authRoleBo = AuthRoleDtoConvert.INSTANCE.convertDtoToBo(authRoleDto);
            return Result.ok(authRoleDomainService.addRole(authRoleBo));
        }catch (Exception e){
            log.info("AuthRoleController.addRole.error:{}: ", e.getMessage(),e);
            return Result.fail("新增角色失败");

        }
    }

    /**
     * 修改角色
     * @param authRoleDto
     * @return
     */
    @PostMapping("update")
    public Result<Boolean> updateRole(@RequestBody AuthRoleDto authRoleDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthRoleController.update: authRoleDto={}", JSON.toJSONString(authRoleDto));
            }
            Preconditions.checkNotNull(authRoleDto.getId(),"id不能为空");
            AuthRoleBo authRoleBo = AuthRoleDtoConvert.INSTANCE.convertDtoToBo(authRoleDto);
            return Result.ok(authRoleDomainService.updateRole(authRoleBo));
        }catch (Exception e){
            log.info("AuthRoleController.updateRole.error:{}: ", e.getMessage(),e);
            return Result.fail("修改角色失败");
        }
    }


    /**
     * 删除角色
     * @param authRoleDto
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> deleteRole(@RequestBody AuthRoleDto authRoleDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthRoleController.delete: authRoleDto={}", JSON.toJSONString(authRoleDto));
            }
            Preconditions.checkNotNull(authRoleDto.getId(),"id不能为空");
            AuthRoleBo authRoleBo = AuthRoleDtoConvert.INSTANCE.convertDtoToBo(authRoleDto);
            return Result.ok(authRoleDomainService.deleteRole(authRoleBo));
        }catch (Exception e){
            log.info("AuthRoleController.deleteRole.error:{}: ", e.getMessage(),e);
            return Result.fail("删除角色");
        }
    }

    /**
     * 查询所有的角色
     * @param
     * @return
     */
    @PostMapping("queryAllRole")
    public Result<List<AuthRoleDto>> queryAllRole(){
        try {
            List<AuthRoleBo> authRoleBoList =
                    authRoleDomainService.queryAllRole(0);
            List<AuthRoleDto> authRoleDtos = AuthRoleDtoConvert.INSTANCE.convertBoToDtoList(authRoleBoList);
            return Result.ok(authRoleDtos);
        }catch (Exception e){
            log.info("AuthRoleController.deleteRole.error:{}: ", e.getMessage(),e);
            return Result.fail("查询所有角色");
        }
    }

}
