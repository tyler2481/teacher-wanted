package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.FavoriteTeacherDao;
import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.model.vo.FavoriteTeacherVo;
import com.project3.teacherwanted.service.FavoriteTeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FavoriteTeacherServiceImpl implements FavoriteTeacherService {
    @Autowired
    private FavoriteTeacherDao favoriteTeacherDao;
    @Override
    public List<FavoriteTeacherVo> findAll() {
        return favoriteTeacherDao.findAll();
    }

    @Override
    public FavoriteTeacherVo getFavTeacherById(Integer id) {
        return favoriteTeacherDao.getFavTeacherById(id);
    }

    @Override
    public void createFavTeacher(FavoriteTeacherVo favoriteTeacher) {
        favoriteTeacherDao.createFavTeacher(favoriteTeacher);
    }

    @Override
    public void deleteFavTeacher(Integer memId, Integer teaId) {
        favoriteTeacherDao.deleteFavTeacher(memId, teaId);
    }

    @Override
    public int checkFavTeacher(Integer memId, Integer teaId) {
        return favoriteTeacherDao.checkFavTeacher(memId, teaId);
    }
}
