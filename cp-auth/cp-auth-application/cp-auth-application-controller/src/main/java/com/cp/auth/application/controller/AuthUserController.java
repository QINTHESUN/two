package com.cp.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.cp.api.entity.AuthUserDto;
import com.cp.auth.application.convert.AuthUserDtoConvert;
import com.cp.auth.common.entity.Result;
import com.cp.auth.domain.bo.AuthUserBo;
import com.cp.auth.domain.service.AuthUserDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/25 下午2:02
 **/
@RestController
@RequestMapping("/auth/user/")
@Slf4j
public class AuthUserController {

    @Resource
    private AuthUserDomainService authUserDomainService;


    /**
     * 注册用户
     * @param authUserDto
     * @return
     */
    @PostMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDto authUserDto){
        try {
            if(log.isInfoEnabled()){
                log.info("AuthUserController.register.dto:{}", JSON.toJSONString(authUserDto));
            }
            Preconditions.checkNotNull(authUserDto.getUserName(),"用户名称/账号不能为空");
            Preconditions.checkNotNull(authUserDto.getNickName(),"用户昵称不能为空");
            Preconditions.checkNotNull(authUserDto.getPassword(),"密码不能为空");
            Preconditions.checkNotNull(authUserDto.getEmail(),"邮箱不能为空");
            Preconditions.checkNotNull(authUserDto.getPhone(),"手机号不能为空");
            Preconditions.checkNotNull(authUserDto.getSex(),"性别不能为空");
            AuthUserBo authUserBo = AuthUserDtoConvert.INSTANCE.convertDtoToBo(authUserDto);
            return Result.ok(authUserDomainService.register(authUserBo));
        }catch (Exception e){
            log.info("AuthUserController.register.error:{}",e.getMessage(),e);
            return Result.fail("注册失败");
        }
    }

    /**
     * 登录
     * @param validCode
     * @return
     */
    @PostMapping("doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthUserController.login.dto:{}", JSON.toJSONString(validCode));
            }
            Preconditions.checkNotNull(validCode,"验证码不能为空");
            SaTokenInfo tokenInfo = authUserDomainService.doLogin(validCode);
            Object loginId = tokenInfo.getLoginId();
            return Result.ok(tokenInfo);
        }catch (Exception e){
            log.info("AuthUserController.login.error:{}",e.getMessage(),e);
            return Result.fail("登录失败");
        }
    }


    /**
     * 修改用户信息
     * @param authUserDto
     * @return
     */
    @PostMapping("updateInfo")
    public Result<Boolean> updateInfo(@RequestBody AuthUserDto authUserDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthUserController.update.dto:{}", JSON.toJSONString(authUserDto));
            }
            Preconditions.checkNotNull(authUserDto.getId(),"用户id不能为空");
            Preconditions.checkNotNull(authUserDto.getNickName(),"用户昵称不能为空");
            Preconditions.checkNotNull(authUserDto.getPassword(),"密码不能为空");
            Preconditions.checkNotNull(authUserDto.getEmail(),"邮箱不能为空");
            Preconditions.checkNotNull(authUserDto.getPhone(),"手机号不能为空");
            AuthUserBo authUserBo = AuthUserDtoConvert.INSTANCE.convertDtoToBo(authUserDto);
            return Result.ok(authUserDomainService.updateInfo(authUserBo));
        }catch (Exception e){
            log.info("AuthUserController.update.error:{}",e.getMessage(),e);
            return Result.fail("修改用户信息失败");
        }
    }


    /**
     * 删除用户
     * @param authUserDto
     * @return
     */
    @PostMapping("deleteUser")
    public Result<Boolean>  deleteUser(@RequestBody AuthUserDto authUserDto){
        try{
            if(log.isInfoEnabled()){
                log.info("AuthUserController.deleteDto:{}", JSON.toJSONString(authUserDto));
            }
            Preconditions.checkNotNull(authUserDto.getId(),"用户id不能为空");
            AuthUserBo authUserBo = AuthUserDtoConvert.INSTANCE.convertDtoToBo(authUserDto);
            return Result.ok(authUserDomainService.deleteUser(authUserBo));
        }catch (Exception e){
            log.info("AuthUserController.deleteUser.error:{}",e.getMessage(),e);
            return Result.fail("删除用户失败");
        }
    }


    /**
     * 获取用户信息
     * @param authUserDto
     * @return
     */
    @PostMapping("getInfo")
    public Result<AuthUserDto> getInfo(@RequestBody AuthUserDto authUserDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthUserController.getInfo.dto:{}", JSON.toJSONString(authUserDto));
            }
            Preconditions.checkNotNull(authUserDto.getUserName(),"用户名不能为空");
            AuthUserBo authUserBo = AuthUserDtoConvert.INSTANCE.convertDtoToBo(authUserDto);
            AuthUserBo boResult = authUserDomainService.getInfo(authUserBo);
            AuthUserDto dtoResult = AuthUserDtoConvert.INSTANCE.convertBoToDto(boResult);
            return Result.ok(dtoResult);
        }catch (Exception e){
            log.info("AuthUserController.getInfo.error:{}",e.getMessage(),e);
            return Result.fail("获取用户信息失败");
        }
    }



    /**
     * 启用/禁用用户状态
     * @param authUserDto
     * @return
     */
    @PostMapping("changeStatus")
    public Result<Boolean> changeStatus(@RequestBody AuthUserDto authUserDto){
        try {
            if (log.isInfoEnabled()){
                log.info("AuthUserController.changeStatus.dto:{}", JSON.toJSONString(authUserDto));
            }
            Preconditions.checkNotNull(authUserDto.getStatus(),"用户状态不能为空");
            AuthUserBo authUserBo = AuthUserDtoConvert.INSTANCE.convertDtoToBo(authUserDto);
            return Result.ok(authUserDomainService.updateStatus(authUserBo));
        }catch (Exception e){
            log.info("AuthUserController.changeStatus.error:{}",e.getMessage(),e);
            return Result.fail("状态修改失败");
        }
    }



    /**
     * 用户退出
     */
    @RequestMapping("logOut")
    public Result logOut(@RequestParam String userName) {
        try {
            log.info("UserController.logOut.userName:{}", userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "用户名不能为空");
            StpUtil.logout();
            return Result.ok();
        } catch (Exception e) {
            log.error("UserController.logOut.error:{}", e.getMessage(), e);
            return Result.fail("用户登出失败");
        }
    }


    /**
     * 获取所有用户
     * @param
     * @return
     */
    @PostMapping("queryAllUser")
    public Result<List<AuthUserDto>>  queryAllUser(){
        try{
            List<AuthUserBo> authUserBoList =
                    authUserDomainService.queryAllUser(0);
            List<AuthUserDto> authUserDtos = AuthUserDtoConvert.INSTANCE.convertBoListToDtoList(authUserBoList);
            return Result.ok(authUserDtos);
        }catch (Exception e){
            log.info("AuthUserController.deleteUser.error:{}",e.getMessage(),e);
            return Result.fail("删除用户失败");
        }
    }

    //
    // /**
    //  * 登录测试
    //  */
    // @RestController
    // @RequestMapping("doLogin")
    // public class LoginController {
    //
    //     // 测试登录  ---- http://localhost:3001/aut/user/doLogin?name=zhang&pwd=123456
    //     @RequestMapping("doLogin")
    //     public SaResult doLogin(String name, String pwd) {
    //         // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
    //         if("zhang".equals(name) && "123456".equals(pwd)) {
    //             StpUtil.login(10001);
    //             return SaResult.ok("登录成功");
    //         }
    //         return SaResult.error("登录失败");
    //     }
    //
    //     // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    //     @RequestMapping("isLogin")
    //     public SaResult isLogin() {
    //         return SaResult.ok("是否登录：" + StpUtil.isLogin());
    //     }
    //
    //     // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    //     @RequestMapping("tokenInfo")
    //     public SaResult tokenInfo() {
    //         return SaResult.data(StpUtil.getTokenInfo());
    //     }
    //
    //     // 测试注销  ---- http://localhost:8081/acc/logout
    //     @RequestMapping("logout")
    //     public SaResult logout() {
    //         StpUtil.logout();
    //         return SaResult.ok();
    //     }
    //
    // }
    //

}
