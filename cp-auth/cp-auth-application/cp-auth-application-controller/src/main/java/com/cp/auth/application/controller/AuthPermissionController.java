package com.cp.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.auth.application.convert.AuthPermissionDtoConvert;
import com.cp.auth.application.dto.AuthPermissionDto;
import com.cp.auth.common.entity.Result;
import com.cp.auth.domain.bo.AuthPermissionBo;
import com.cp.auth.domain.service.AuthPermissionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/27 下午5:11
 **/
@RestController
@RequestMapping("/permission/")
@Slf4j
public class AuthPermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;


    /**
     * 添加权限
     *
     * @param authPermissionDto
     * @return
     */
    @PostMapping("addPermission")
    public Result<Boolean> addPermission(@RequestBody AuthPermissionDto authPermissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.addPermission authPermissionDto: {}", JSON.toJSONString(authPermissionDto));
            }
            Preconditions.checkNotNull(authPermissionDto.getName(), "权限名不能为空");
            Preconditions.checkNotNull(authPermissionDto.getPermissionKey(), "权限唯一标识不能为空");
            AuthPermissionBo authPermissionBo = AuthPermissionDtoConvert.INSTANCE.convertDtoToBo(authPermissionDto);
            return Result.ok(authPermissionDomainService.addPermission(authPermissionBo));
        } catch (Exception e) {
            log.info("AuthPermissionController.addPermission error:{}", e.getMessage(), e);
            return Result.fail("添加权限失败");
        }
    }


    /**
     * 修改权限
     *
     * @param authPermissionDto
     * @return
     */
    @PostMapping("updatePermission")
    public Result<Boolean> updatePermission(@RequestBody AuthPermissionDto authPermissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.updatePermission authPermissionDto: {}", JSON.toJSONString(authPermissionDto));
            }
            Preconditions.checkNotNull(authPermissionDto.getId(), "id不能为空");
            AuthPermissionBo authPermissionBo = AuthPermissionDtoConvert.INSTANCE.convertDtoToBo(authPermissionDto);
            return Result.ok(authPermissionDomainService.updatePermission(authPermissionBo));
        } catch (Exception e) {
            log.info("AuthPermissionController.updatePermission error:{}", e.getMessage(), e);
            return Result.fail("修改权限失败");
        }
    }


    /**
     * 删除权限
     *
     * @param authPermissionDto
     * @return
     */
    @PostMapping("deletePermission")
    public Result<Boolean> deletePermission(@RequestBody AuthPermissionDto authPermissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.deletePermission authPermissionDto: {}", JSON.toJSONString(authPermissionDto));
            }
            Preconditions.checkNotNull(authPermissionDto.getId(), "id不能为空");
            AuthPermissionBo authPermissionBo = AuthPermissionDtoConvert.INSTANCE.convertDtoToBo(authPermissionDto);
            return Result.ok(authPermissionDomainService.deletePermission(authPermissionBo));
        } catch (Exception e) {
            log.info("AuthPermissionController.deletePermission error:{}", e.getMessage(), e);
            return Result.fail("删除权限失败");
        }
    }


    /**
     * 查询权限
     *
     * @param
     * @return
     */
    @PostMapping("queryPermission")
    public Result<List<String>> queryPermission(String userName) {
        try {
            log.info("PermissionController.getPermission.userName:{}", userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "用户名不能为空");
            return Result.ok(authPermissionDomainService.queryPermission(userName));
        } catch (Exception e) {
            log.info("AuthPermissionController.queryPermission error:{}", e.getMessage(), e);
            return Result.fail("查找权限失败");
        }
    }


    /**
     * 查询所有权限
     *
     * @param
     * @return
     */
    @PostMapping("queryAllPermission")
    public Result<List<AuthPermissionDto>> queryAllPermission() {
        try {
            List<AuthPermissionBo> authPermissionBoList =
                    authPermissionDomainService.queryAllPermission();
            List<AuthPermissionDto> authPermissionDtos = AuthPermissionDtoConvert.INSTANCE.convertBoToDtoList(authPermissionBoList);
            return Result.ok(authPermissionDtos);
        } catch (Exception e) {
            log.info("AuthPermissionController.queryPermission error:{}", e.getMessage(), e);
            return Result.fail("查找所有权限失败");
        }
    }
}
