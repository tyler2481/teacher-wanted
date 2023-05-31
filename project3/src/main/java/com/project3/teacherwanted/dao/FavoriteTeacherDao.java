package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.vo.FavoriteTeacherVo;

import java.util.List;

public interface FavoriteTeacherDao {
    List<FavoriteTeacherVo> findAll();
    FavoriteTeacherVo getFavTeacherById(Integer id);
    void createFavTeacher(FavoriteTeacherVo favoriteTeacher);
    void deleteFavTeacher(Integer memId, Integer teaId);

    int checkFavTeacher(Integer memId, Integer teaId);
}
