package com.cp.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.subject.application.convert.SubjectLikedDtoConvert;
import com.cp.subject.application.dto.SubjectLikedDto;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.common.entity.Result;
import com.cp.subject.common.util.LoginUtil;
import com.cp.subject.domain.bo.SubjectLikedBo;
import com.cp.subject.domain.service.SubjectLikedDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/3 下午11:44
 **/
@RestController
@RequestMapping("/subject/liked/")
@Slf4j
public class SubjectLikedController {

    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;


    /**
     * 新增题目点赞列表
     * @param subjectLikedDto
     * @return
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectLikedDto subjectLikedDto){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLikedController.add subjectLikedDto: {}", JSON.toJSONString(subjectLikedDto));
            }
            Preconditions.checkNotNull(subjectLikedDto.getSubjectId(),"题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDto.getStatus(),"点赞状态不能为空");
            String loginId = LoginUtil.getLoginId();
            subjectLikedDto.setLikeUserId(loginId);
            Preconditions.checkNotNull(subjectLikedDto.getLikeUserId(),"点赞人不能为空");
            SubjectLikedBo subjectLikedBo = SubjectLikedDtoConvert.INSTANCE.convertDtoToBo(subjectLikedDto);
            subjectLikedDomainService.addLiked(subjectLikedBo);
            return Result.ok(true);
        }catch (Exception e){
            log.info("SubjectLikedController.add.error: {}", e.getMessage(),e);
            return Result.fail("新增题目点赞列表失败");
        }
    }




    /**
     * 查询分页点赞列表
     * @param subjectLikedDto
     * @return
     */
    @PostMapping("getSubjectLikedPage")
    public Result<PageResult<SubjectLikedDto>> getSubjectLikedPage(@RequestBody SubjectLikedDto subjectLikedDto){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectLikedController.getSubjectLikedPage subjectLikedDto: {}", JSON.toJSONString(subjectLikedDto));
            }
            SubjectLikedBo subjectLikedBo = SubjectLikedDtoConvert.INSTANCE.convertDtoToBo(subjectLikedDto);
            subjectLikedBo.setPageNo(subjectLikedDto.getPageNo());
            subjectLikedBo.setPageSize(subjectLikedDto.getPageSize());
            PageResult<SubjectLikedBo> boPageResult =
                    subjectLikedDomainService.getSubjectLikedPage(subjectLikedBo);
            return Result.ok(boPageResult);
        }catch (Exception e){
            log.info("SubjectLikedController.getSubjectLikedPage.error: {}", e.getMessage(),e);
            return Result.fail("查询题目点赞列表失败");
        }
    }


}
