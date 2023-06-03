package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.CommentReplyDao;
import com.project3.teacherwanted.model.vo.CommentReplyVo;
import com.project3.teacherwanted.service.CommentReplyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentReplyServiceImpl implements CommentReplyService {
    @Autowired
    private CommentReplyDao commentReplyDao;
    @Override
    public List<CommentReplyVo> findAll() {
        return commentReplyDao.findAll();
    }

    @Override
    public List<CommentReplyVo> getRepliesByCommentId(Integer commentId) {
        return commentReplyDao.getRepliesByCommentId(commentId);
    }

    @Override
    public CommentReplyVo getReplyById(Integer id) {
        return commentReplyDao.getReplyById(id);
    }

    @Override
    public void createReply(CommentReplyVo commentReply) {
        commentReplyDao.createReply(commentReply);
    }

    @Override
    public void updateReply(CommentReplyVo commentReply) {
        commentReplyDao.updateReply(commentReply);
    }

    @Override
    public void deleteReply(Integer id) {
        commentReplyDao.deleteReply(id);
    }

    @Override
    public int deleteRepliesByCommentId(Integer id) {
        return commentReplyDao.deleteRepliesByCommentId(id);
    }
}
