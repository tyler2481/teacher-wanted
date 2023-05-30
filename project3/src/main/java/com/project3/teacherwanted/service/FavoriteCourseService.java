package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;

import java.util.List;

public interface FavoriteCourseService {
    List<FavoriteCourseVo> findAll();
    FavoriteCourseVo getFavCourseById(Integer id);
    void createFavCourse(FavoriteCourseVo favoriteCourse);
    void deleteFavCourse(Integer id);
}
