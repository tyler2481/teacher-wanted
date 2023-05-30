package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.FavoriteCourseDao;
import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.model.vo.TeacherVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteCourseDaoImpl implements FavoriteCourseDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<FavoriteCourseVo> findAll() {
        String hql = "FROM  FavoriteCourseVo ORDER BY courseId";
        return (List<FavoriteCourseVo>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public FavoriteCourseVo getFavCourseById(Integer id) {
        return entityManager.find(FavoriteCourseVo.class, id);
    }

    @Override
    public void createFavCourse(FavoriteCourseVo favoriteCourse) {
        entityManager.persist(favoriteCourse);
    }

    @Override
    public void deleteFavCourse(Integer id) {
        entityManager.remove(getFavCourseById(id));
    }
}
