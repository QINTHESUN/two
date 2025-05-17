package com.cp.subject.infra.basic.service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.subject.infra.basic.entity.CommentsEntity;

/**
 * (Comments)表服务接口
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */
public interface CommentsService extends IService<CommentsEntity> {

    /**
     * 根据题目id获取评论列表
     * @param commentsEntity
     * @return
     */
    List<CommentsEntity> getAllComments(CommentsEntity commentsEntity);
}
