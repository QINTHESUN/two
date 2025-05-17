package com.cp.subject.infra.basic.service.impl;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.infra.basic.mapper.CommentsDao;
import com.cp.subject.infra.basic.entity.CommentsEntity;
import com.cp.subject.infra.basic.service.CommentsService;
import com.cp.subject.infra.rpc.UserRpc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Comments)表服务实现类
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsEntity> implements CommentsService {

    @Resource
    private CommentsDao commentsDao;


    @Override
    public List<CommentsEntity> getAllComments(CommentsEntity commentsEntity) {
        LambdaQueryWrapper<CommentsEntity> commentsEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentsEntityLambdaQueryWrapper.eq(CommentsEntity::getTopicId,commentsEntity.getTopicId())
                .eq(CommentsEntity::getIsDeleted, IsDeletedFlagEnum.UN_DELETED.getCode());
        return commentsDao.selectList(commentsEntityLambdaQueryWrapper);
    }
}
