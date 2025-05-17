package com.cp.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cp.subject.application.convert.CommentsDtoConvert;
import com.cp.subject.application.dto.CommentsDto;
import com.cp.subject.common.entity.Result;
import com.cp.subject.domain.bo.CommentsBo;
import com.cp.subject.domain.service.CommentsDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 2024/11/8 下午3:18
 **/
@RestController
@Slf4j
@RequestMapping("/subject/comments/")
public class CommentController {

    @Resource
    private CommentsDomainService commentsDomainService;


    /**
     * 发布评论
     *
     * @param commentsDto
     * @return
     */
    @PostMapping("addComment")
    public Result<Boolean> addComment(@RequestBody CommentsDto commentsDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommentController.addComment.dto:{}", JSON.toJSONString(commentsDto));
            }
            Preconditions.checkNotNull(commentsDto.getContent(),"评论内容不能为空");
            Preconditions.checkNotNull(commentsDto.getTopicId(),"题目id不能为空");
            CommentsBo commentsBo = CommentsDtoConvert.INSTANCE.convertDtoToBo(commentsDto);
            return Result.ok(commentsDomainService.addComment(commentsBo));
        } catch (Exception e) {
            log.info("CommentController.addComment.Exception:{}", e.getMessage(), e);
            return Result.fail("发布评论失败");
        }
    }


    /**
     * 获取评论
     * @param commentsDto
     * @return
     */
    @PostMapping("getAllComments")
    public Result<List<CommentsDto>> getAllComments(@RequestBody CommentsDto commentsDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommentController.getAllComments.dto:{}", JSON.toJSONString(commentsDto));
            }
            Preconditions.checkNotNull(commentsDto.getTopicId(),"题目id不能为空");
            CommentsBo commentsBo = CommentsDtoConvert.INSTANCE.convertDtoToBo(commentsDto);
            List<CommentsBo> commentsBoList =
                    commentsDomainService.getAllComments(commentsBo);
            List<CommentsDto> commentsDtos = CommentsDtoConvert.INSTANCE.convertBoToDtoList(commentsBoList);

            List<CommentsDto> comments = commentsDtos.stream()
                    .filter(c -> c.getParentId() == null)
                    .collect(Collectors.toList());
            for (CommentsDto comment : comments) {
                comment.setReplies(
                        commentsDtos.stream()
                                .filter(c -> c.getParentId() != null &&  c.getParentId().equals(comment.getId()))
                                .collect(Collectors.toList())
                );
            }
            return Result.ok(comments);
        }catch (Exception e){
            log.info("CommentController.addComment.Exception:{}", e.getMessage(), e);
            return Result.fail("查询列表失败");
        }
    }





}
