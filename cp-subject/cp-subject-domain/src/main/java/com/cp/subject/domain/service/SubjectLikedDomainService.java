package com.cp.subject.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.common.entity.PageResult;
import com.cp.subject.domain.bo.SubjectLikedBo;
import com.cp.subject.infra.basic.entity.SubjectLikedEntity;

/**
 * 题目点赞表(SubjectLiked)表服务接口
 * 
 * @author makejava
 * @since 2024-10-31 10:34:01
 */
public interface SubjectLikedDomainService {

    /**
     * 新增点赞
     * @param subjectLikedBo
     * @return
     */
    void addLiked(SubjectLikedBo subjectLikedBo);

    /**
     * 获取当前是否被点赞过
     * @param subjectId
     * @param userId
     * @return
     */
    Boolean isLiked(String subjectId, String userId);

    /**
     * 获取点赞数量
     * @param subjectId
     * @return
     */
    Integer getLikedCount(String subjectId);

    /**
     * 同步点赞数据
     */
    void syncLiked();

    /**
     * 分页查询点赞列表
     * @param subjectLikedBo
     * @return
     */
    PageResult<SubjectLikedBo> getSubjectLikedPage(SubjectLikedBo subjectLikedBo);
}
