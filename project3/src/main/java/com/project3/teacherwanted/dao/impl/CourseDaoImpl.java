package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.List;


@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private Session session;

    @Override
    public List<CourseVo> getCourses(int page, int pageSize, Integer courseCategoryId, String keyword) {
        String hql = "FROM CourseVo";

        // 根据查询条件构建查询语句
        if (courseCategoryId != null || keyword != null) {
            hql += " WHERE";
            if (courseCategoryId != null) {
                hql += " courseCategoryId = :courseCategoryId";
            }
            if (keyword != null) {
                if (courseCategoryId != null) {
                    hql += " AND";
                }
                hql += " (courseName LIKE :keyword OR courseDetail LIKE :keyword)";
            }
        }

        // 创建查询对象
        Query<CourseVo> query = session.createQuery(hql, CourseVo.class);

        // 设置查询参数
        if (courseCategoryId != null) {
            query.setParameter("courseCategoryId", courseCategoryId);
        }
        if (keyword != null) {
            query.setParameter("keyword", "%" + keyword + "%");
        }

        // 分页查询
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);

        // 执行查询并返回结果
        List<CourseVo> courseList = query.getResultList();
        return courseList;
    }

    @Override
    public CourseVo getCourseById(Integer courseId) {
        return session.find(CourseVo.class, courseId);
    }
    @Override
    public List<CourseVo> getCoursesByKeyword(String keyword) {
        String hql = "FROM CourseVo WHERE courseName LIKE :keyword";
        TypedQuery<CourseVo> query = session.createQuery(hql, CourseVo.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    @Override
    public List<CourseVo> getCoursesByTeacher(Integer teaId) {
        String hql = "FROM CourseVo WHERE teaId = :teaId";
        TypedQuery<CourseVo> query = session.createQuery(hql, CourseVo.class);
        query.setParameter("teaId", teaId );
        return query.getResultList();
    }

    @Override
    public Integer createCourse(CourseVo courseVo) throws IOException {
        session.persist(courseVo);
        session.flush();
        Integer primaryKey = courseVo.getCourseId();
        return primaryKey;
    }

    @Override
    public void updateCourse(Integer courseId, CourseRequest courseRequest) {

    }

    @Override
    public void deleteCourseById(Integer courseId) {
        session.remove(getCourseById(courseId));
    }
}
