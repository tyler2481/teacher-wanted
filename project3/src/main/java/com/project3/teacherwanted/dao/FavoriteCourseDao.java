package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;

import java.util.List;

public interface FavoriteCourseDao {
    List<FavoriteCourseVo> findAll();
    FavoriteCourseVo getFavCourseById(Integer id);
    void createFavCourse(FavoriteCourseVo favoriteCourse);
    void deleteFavCourse(Integer id);
}
