package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.CourseChapterDao;
import com.project3.teacherwanted.model.vo.CourseChapterVo;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseChapterDaoImpl implements CourseChapterDao{
    @PersistenceContext
    private Session session;

    @Override
    public List<CourseChapterVo> findByCourseId(Integer courseId) {
        String hql = "FROM CourseChapterVo c WHERE c.courseId = :courseId";
        Query<CourseChapterVo> query = session.createQuery(hql, CourseChapterVo.class);
        query.setParameter("courseId", courseId);
        return query.getResultList();
    }
    @Override
    public CourseChapterVo findById(Integer id) {
        return session.find(CourseChapterVo.class, id);
    }

    @Override
    public Integer createChapters(CourseChapterVo chapterVo) {
        session.persist(chapterVo);
        session.flush();
        return chapterVo.getChapterId();
    }

    @Override
    public void updateChapter(Integer courseId, CourseChapterVo chapterVo) {
        chapterVo.setCourseId(courseId);
        session.merge(chapterVo);
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        CourseChapterVo chapterVo = session.find(CourseChapterVo.class, courseId);
        if (chapterVo != null) {
            session.remove(chapterVo);
        }
    }
}
