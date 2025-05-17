package com.cp.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.subject.application.convert.SubjectCategoryDtoConvert;
import com.cp.subject.application.convert.SubjectLabelDtoConvert;
import com.cp.subject.application.dto.SubjectCategoryDto;
import com.cp.subject.application.dto.SubjectLabelDto;
import com.cp.subject.common.entity.Result;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.util.LoginUtil;
import com.cp.subject.domain.bo.SubjectCategoryBo;
import com.cp.subject.domain.service.SubjectCategoryDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目分类controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 上午2:52
 **/
@RestController
@RequestMapping("/subject/category/")
@Slf4j
public class SubjectCategoryController {


    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;


    /**
     * 添加题目分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDto subjectCategoryDto){
        try{
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getCategoryName(),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getCategoryType(),"分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(),"分类id不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            return Result.ok(subjectCategoryDomainService.add(subjectCategoryBo));

        }catch (Exception e){
            log.info("SubjectCategoryController.add.error:{}", e.getMessage(),e);
            return Result.fail("新增题目分类失败");
        }
    }


    /**
     * 修改题目分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDto subjectCategoryDto){
        try{
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getId(),"主键不能为空");
           SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            return Result.ok(subjectCategoryDomainService.update(subjectCategoryBo));

        }catch (Exception e){
            log.info("SubjectCategoryController.update.error:{}", e.getMessage(),e);
            return Result.fail("修改题目分类失败");
        }
    }


    /**
     * 删除题目分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDto subjectCategoryDto){
        try{
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getId(),"主键不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            return Result.ok(subjectCategoryDomainService.delete(subjectCategoryBo));
        }catch (Exception e){
            log.info("SubjectCategoryController.delete.error:{}", e.getMessage(),e);
            return Result.fail("删除题目分类失败");
        }
    }



    /**
     * 根据category_type查询题目分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("queryByType")
    public Result<List<SubjectCategoryDto>> queryByType(@RequestBody SubjectCategoryDto subjectCategoryDto){
        try{
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryByType.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            SubjectCategoryBo subjectCategoryBo =
                    SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBoList =
                    subjectCategoryDomainService.queryByType(subjectCategoryBo);
            List<SubjectCategoryDto> subjectCategoryDtoList =
                    SubjectCategoryDtoConvert.INSTANCE.convertBoToDtoList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDtoList);
        }catch (Exception e){
            log.info("SubjectCategoryController.queryByType.error:{}", e.getMessage(),e);
            return Result.fail("查询题目分类失败");
        }
    }


    /**
     * 查询分类及标签一次性
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("queryCategoryAndLabel")
    public Result<SubjectCategoryDto> queryCategoryAndLabel(@RequestBody SubjectCategoryDto subjectCategoryDto){
        try{
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryCategoryAndLabel.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            String loginId = LoginUtil.getLoginId();
            log.info("`````loginId:{}````", loginId);
            SubjectCategoryBo subjectCategoryBo =
                    SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBoList =
                    subjectCategoryDomainService.queryCategoryAndLabel(subjectCategoryBo);
            List<SubjectCategoryDto> subjectCategoryDtoList = new LinkedList<>();
            subjectCategoryBoList.forEach(categoryBo -> {
                SubjectCategoryDto categoryDto = SubjectCategoryDtoConvert.INSTANCE.convertBoToDto(categoryBo);
                List<SubjectLabelDto> subjectLabelDtoList = SubjectLabelDtoConvert.INSTANCE.convertBoListToDtoList(categoryBo.getLabelBOList());
                categoryDto.setLabelDTOList(subjectLabelDtoList);
                subjectCategoryDtoList.add(categoryDto);
            });
            return Result.ok(subjectCategoryDtoList);
        }catch (Exception e){
            log.info("SubjectCategoryController.queryCategoryAndLabel.error:{}", e.getMessage(),e);
            return Result.fail("查询大类及分类");
        }
    }

    /**
     * 查询所有的分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("queryAllCategory")
    public Result<List<SubjectCategoryDto>> queryAllCategory(){
        try{
            List<SubjectCategoryBo> subjectCategoryBoList =
                    subjectCategoryDomainService.queryAll(0);
            List<SubjectCategoryDto> subjectCategoryDtoList = SubjectCategoryDtoConvert.INSTANCE.convertBoToDtoList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDtoList);
        }catch (Exception e){
            log.info("SubjectCategoryController.queryByType.error:{}", e.getMessage(),e);
            return Result.fail("查询所有分类失败");
        }
    }


}
