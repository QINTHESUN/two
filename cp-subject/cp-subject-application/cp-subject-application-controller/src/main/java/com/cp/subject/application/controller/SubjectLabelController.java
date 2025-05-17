package com.cp.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.subject.application.convert.SubjectLabelDtoConvert;
import com.cp.subject.application.dto.SubjectLabelDto;
import com.cp.subject.common.entity.Result;
import com.cp.subject.domain.bo.SubjectLabelBo;
import com.cp.subject.domain.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类标签controller
 *
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/10/22 下午2:21
 **/
@RestController
@RequestMapping("/subject/label/")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;


    /**
     * 添加分类标签
     *
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDto));
            }
            Preconditions.checkNotNull(subjectLabelDto.getLabelName(), "标签分类不i能为空");
            Preconditions.checkNotNull(subjectLabelDto.getSortNum(), "排序不能为空");
            Preconditions.checkNotNull(subjectLabelDto.getCategoryId(), "分类id不能为空");
            SubjectLabelBo subjectLabelBo =
                    SubjectLabelDtoConvert.INSTANCE.convertDtoToBo(subjectLabelDto);
            return Result.ok(subjectLabelDomainService.add(subjectLabelBo));
        } catch (Exception e) {
            log.info("SubjectLabelController.add.error:{}", e.getMessage(), e);
            return Result.fail("添加分类标签失败");
        }
    }


    /**
     * 添加分类标签
     *
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDto));
            }
            Preconditions.checkNotNull(subjectLabelDto.getId(), "分类id不能为空");
            SubjectLabelBo subjectLabelBo =
                    SubjectLabelDtoConvert.INSTANCE.convertDtoToBo(subjectLabelDto);
            return Result.ok(subjectLabelDomainService.update(subjectLabelBo));
        } catch (Exception e) {
            log.info("SubjectLabelController.update.error:{}", e.getMessage(), e);
            return Result.fail("修改分类标签失败");
        }
    }

    /**
     * 删除分类标签
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDto));
            }
            Preconditions.checkNotNull(subjectLabelDto.getId(), "标签id不能为空");
            SubjectLabelBo subjectLabelBo =
                    SubjectLabelDtoConvert.INSTANCE.convertDtoToBo(subjectLabelDto);
            return Result.ok(subjectLabelDomainService.delete(subjectLabelBo));
        } catch (Exception e) {
            log.info("SubjectLabelController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除分类标签失败");
        }
    }


    /**
     * 根据分类id查询标签
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("queryByCategoryId")
    public Result<List<SubjectLabelDto>> queryByCategoryId(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDto));
            }
            Preconditions.checkNotNull(subjectLabelDto.getCategoryId(), "分类id不能为空");
            SubjectLabelBo subjectLabelBo =
                    SubjectLabelDtoConvert.INSTANCE.convertDtoToBo(subjectLabelDto);
            List<SubjectLabelBo> subjectLabelBoList = subjectLabelDomainService.queryByCategoryId(subjectLabelBo);
            List<SubjectLabelDto> subjectLabelDtoList = SubjectLabelDtoConvert.INSTANCE.convertBoListToDtoList(subjectLabelBoList);
            return Result.ok(subjectLabelDtoList);
        } catch (Exception e) {
            log.info("SubjectLabelController.queryByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("查询分类标签失败");
        }
    }


}
