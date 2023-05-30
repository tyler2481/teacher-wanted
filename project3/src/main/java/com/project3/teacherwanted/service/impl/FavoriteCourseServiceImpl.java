package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.FavoriteCourseDao;
import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.service.FavoriteCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteCourseServiceImpl implements FavoriteCourseService {
    @Autowired
    private FavoriteCourseDao favoriteCourseDao;
    @Override
    public List<FavoriteCourseVo> findAll() {
        return favoriteCourseDao.findAll();
    }

    @Override
    public FavoriteCourseVo getFavCourseById(Integer id) {
        return favoriteCourseDao.getFavCourseById(id);
    }

    @Override
    public void createFavCourse(FavoriteCourseVo favoriteCourse) {
        favoriteCourseDao.createFavCourse(favoriteCourse);
    }

    @Override
    public void deleteFavCourse(Integer id) {
        favoriteCourseDao.deleteFavCourse(id);
    }
}
