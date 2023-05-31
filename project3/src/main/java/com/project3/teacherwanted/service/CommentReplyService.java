package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.vo.CommentReplyVo;

import java.util.List;

public interface CommentReplyService {

    List<CommentReplyVo> findAll();
    List<CommentReplyVo> getRepliesByCommentId(Integer commentReplyId);
    CommentReplyVo getReplyById(Integer id);
    void createReply(CommentReplyVo commentReply);
    void updateReply(CommentReplyVo commentReply);
    void deleteReply(Integer id);
}
