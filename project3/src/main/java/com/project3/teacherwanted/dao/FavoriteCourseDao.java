package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;

import java.util.List;

public interface FavoriteCourseDao {
    List<FavoriteCourseVo> findAll();
    FavoriteCourseVo getFavCourseById(Integer id);
    int checkFavCourse(Integer memId, Integer courseId);
    void createFavCourse(FavoriteCourseVo favoriteCourse);
    void deleteFavCourse(Integer memId, Integer courseId);

}
