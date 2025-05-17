package com.cp.subject.domain.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.domain.bo.CommentsBo;
import com.cp.subject.infra.basic.entity.CommentsEntity;

import java.util.List;

/**
 * (Comments)表服务接口
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */
public interface CommentsDomainService {

    /**
     * 添加评论
     * @param commentsBo
     * @return
     */
    Boolean addComment(CommentsBo commentsBo);

    /**
     * 查询列表根据题目id
     * @param commentsBo
     * @return
     */
    List<CommentsBo> getAllComments(CommentsBo commentsBo);
}
