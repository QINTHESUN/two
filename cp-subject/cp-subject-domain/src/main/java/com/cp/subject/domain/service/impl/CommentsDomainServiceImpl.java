package com.cp.subject.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.subject.common.enums.IsDeletedFlagEnum;
import com.cp.subject.common.util.LoginUtil;
import com.cp.subject.domain.bo.CommentsBo;
import com.cp.subject.domain.convert.CommentsBoConvert;
import com.cp.subject.domain.service.CommentsDomainService;
import com.cp.subject.infra.basic.entity.CommentsEntity;
import com.cp.subject.infra.basic.mapper.CommentsDao;
import com.cp.subject.infra.basic.service.CommentsService;
import com.cp.subject.infra.entity.UserInfo;
import com.cp.subject.infra.rpc.UserRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * (Comments)表服务实现类
 * 
 * @author makejava
 * @since 2024-11-08 15:16:11
 */
@Service
public class CommentsDomainServiceImpl  implements CommentsDomainService {

    private static final Logger log = LoggerFactory.getLogger(CommentsDomainServiceImpl.class);
    @Resource
    private CommentsService commentsService;

    @Resource
    private UserRpc userRpc;


    @Override
    public Boolean addComment(CommentsBo commentsBo) {
        CommentsEntity commentsEntity = CommentsBoConvert.INSTANCE.convertBoToEntity(commentsBo);
        commentsEntity.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        log.info("~~~~~~~loginid",LoginUtil.getLoginId());
        String loginId = LoginUtil.getLoginId();
        UserInfo userInfo = userRpc.getUserInfo(loginId);
        if (StringUtils.isEmpty(userInfo.getNickName())) {
            commentsEntity.setUserId(loginId);
        }
        commentsEntity.setUserId(userInfo.getNickName());
        return commentsService.save(commentsEntity);
    }

    @Override
    public List<CommentsBo> getAllComments(CommentsBo commentsBo) {
        CommentsEntity commentsEntity = CommentsBoConvert.INSTANCE.convertBoToEntity(commentsBo);
        List<CommentsEntity> commentsEntityList =
                commentsService.getAllComments(commentsEntity);
        List<CommentsBo> commentsBoList = CommentsBoConvert.INSTANCE.convertEntityToBoList(commentsEntityList);
        return commentsBoList;
    }
}
