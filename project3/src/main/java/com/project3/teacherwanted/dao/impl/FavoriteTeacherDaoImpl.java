package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.FavoriteTeacherDao;
import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.model.vo.FavoriteTeacherVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteTeacherDaoImpl implements FavoriteTeacherDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<FavoriteTeacherVo> findAll() {
        String hql = "FROM  FavoriteTeacherVo ORDER BY teaId";
        return (List<FavoriteTeacherVo>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public FavoriteTeacherVo getFavTeacherById(Integer id) {
        return entityManager.find(FavoriteTeacherVo.class, id);
    }

    @Override
    public void createFavTeacher(FavoriteTeacherVo favoriteTeacher) {
        entityManager.persist(favoriteTeacher);
    }

    @Override
    public void deleteFavTeacher(Integer id) {
        entityManager.remove(getFavTeacherById(id));
    }
}
