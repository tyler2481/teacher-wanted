package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.CommentReplyDao;
import com.project3.teacherwanted.model.vo.CommentReplyVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentReplyDaoImpl implements CommentReplyDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CommentReplyVo> findAll() {
        String hql = "FROM CommentReplyVo";
        TypedQuery<CommentReplyVo> query = entityManager.createQuery(hql, CommentReplyVo.class);
        return query.getResultList();
    }

    @Override
    public List<CommentReplyVo> getRepliesByCommentId(Integer commentReplyId) {
        String hql = "FROM CommentReplyVo cr WHERE cr.commentReplyId = :commentReplyId";
        TypedQuery<CommentReplyVo> query = entityManager.createQuery(hql, CommentReplyVo.class);
        query.setParameter("commentReplyId", commentReplyId);
        return query.getResultList();
    }

    @Override
    public CommentReplyVo getReplyById(Integer id) {
        return entityManager.find(CommentReplyVo.class, id);
    }

    @Override
    public void createReply(CommentReplyVo commentReply) {
        entityManager.persist(commentReply);
    }

    @Override
    public void updateReply(CommentReplyVo commentReply) {
        entityManager.merge(commentReply);
    }

    @Override
    public void deleteReply(Integer id) {
        entityManager.remove(getReplyById(id));
    }
}
