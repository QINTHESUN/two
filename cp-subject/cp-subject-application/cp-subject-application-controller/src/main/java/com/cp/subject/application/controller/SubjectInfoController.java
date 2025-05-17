package com.cp.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.subject.application.convert.SubjectInfoDtoConvert;
import com.cp.subject.application.dto.SubjectInfoDto;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.common.entity.Result;
import com.cp.subject.domain.bo.SubjectAnswerBo;
import com.cp.subject.domain.bo.SubjectInfoBo;
import com.cp.subject.domain.service.SubjectInfoDomainService;
import com.cp.subject.infra.basic.entity.SubjectInfoEs;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目信息controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午8:07
 **/
@RestController
@RequestMapping("/subject/info")
@Slf4j
public class SubjectInfoController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * 添加题目
     *
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectInfoDto subjectInfoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.add.dto:{}", JSON.toJSONString(subjectInfoDto));
            }
            Preconditions.checkNotNull(subjectInfoDto.getSubjectName(), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectParse(), "题目解析不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDto.getCategoryIds()), "题目分类不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDto.getLabelIds()), "题目标签不能为空");
            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConvert.INSTANCE.convertDtoToBo(subjectInfoDto);
            List<SubjectAnswerBo> subjectAnswerBoList = SubjectInfoDtoConvert.INSTANCE.subjectAnswerDtoToBoList(subjectInfoDto.getOptionList());
            subjectInfoBo.setOptionList(subjectAnswerBoList);
            subjectInfoDomainService.add(subjectInfoBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.info("SubjectInfoController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目信息失败");
        }
    }

    /**
     * 删除题目
     *
     * @param subjectInfoDto
     * @return
     */
    /**
     * 删除题目
     *
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("del")
    public Result<Boolean> del(@RequestBody SubjectInfoDto subjectInfoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.del.dto:{}", JSON.toJSONString(subjectInfoDto));
            }
            Preconditions.checkNotNull(subjectInfoDto.getId(), "题目ID不能为空");
            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConvert.INSTANCE.convertDtoToBo(subjectInfoDto);

            return Result.ok(subjectInfoDomainService.del(subjectInfoBo));
        } catch (Exception e) {
            log.error("SubjectInfoController.del.error:{}", e.getMessage(), e);
            return Result.fail("删除题目信息失败");
        }
    }



    /**
     * 分页查询题目列表
     *
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("getSubjectPage")
    public Result<PageResult<SubjectInfoDto>> getSubjectPage(@RequestBody SubjectInfoDto subjectInfoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDto));
            }
            Preconditions.checkNotNull(subjectInfoDto.getCategoryId(), "题目分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getLabelId(), "分类标签不能为空");
            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConvert.INSTANCE.convertDtoToBo(subjectInfoDto);
            PageResult<SubjectInfoBo> result =
                    subjectInfoDomainService.getSubjectPage(subjectInfoBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.info("SubjectInfoController.getSubjectPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询题目列表失败");
        }
    }


    /**
     * 查询题目详情
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("getSubjectInfo")
    public Result<SubjectInfoDto> getSubjectInfo(@RequestBody SubjectInfoDto subjectInfoDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.getSubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDto));
            }
            Preconditions.checkNotNull(subjectInfoDto.getId(), "题目id不能为空");
            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConvert.INSTANCE.convertDtoToBo(subjectInfoDto);
            SubjectInfoBo boResult =
                    subjectInfoDomainService.getSubjectInfo(subjectInfoBo);
            SubjectInfoDto dtoResult = SubjectInfoDtoConvert.INSTANCE.convertBoToDto(boResult);
            return Result.ok(dtoResult);
        } catch (Exception e) {
            log.info("SubjectInfoController.getSubjectInfo.error:{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }


    /**
     * es高亮搜索
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("querySubjectBySearch")
    public Result<PageResult<SubjectInfoEs>> querySubjectBySearch(@RequestBody SubjectInfoDto subjectInfoDto){
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.querySubjectBySearch.dto:{}", JSON.toJSONString(subjectInfoDto));
            }
            Preconditions.checkNotNull(subjectInfoDto.getKeyWord(),"关键字不能为空");
            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConvert.INSTANCE.convertDtoToBo(subjectInfoDto);
            subjectInfoBo.setPageSize(subjectInfoDto.getPageSize());
            subjectInfoBo.setPageNo(subjectInfoDto.getPageNo());
            PageResult<SubjectInfoEs> subjectInfoEsPageResult =
                    subjectInfoDomainService.querySubjectBySearch(subjectInfoBo);
            return Result.ok(subjectInfoEsPageResult);
        }catch (Exception e){
            log.info("SubjectInfoController.querySubjectBySearch.error:{}", e.getMessage(), e);
            return Result.fail("es关键词搜索失败");
        }
    }


    /**
     * 查询排行榜
     * @return
     */
    @PostMapping("getContributeList")
    public Result<List<SubjectInfoDto>> getContributeList(){
        try {
            List<SubjectInfoBo> subjectInfoBoList =
                    subjectInfoDomainService.getContributeList();
            List<SubjectInfoDto> subjectInfoDtoList =
                    SubjectInfoDtoConvert.INSTANCE.convertBoListToDtoList(subjectInfoBoList);
            return Result.ok(subjectInfoDtoList);
        }catch (Exception e){
            log.info("SubjectInfoController.getContributeList.error:{}", e.getMessage(), e);
            return Result.fail("获取贡献榜失败");
        }
    }



}
