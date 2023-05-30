package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.model.vo.FavoriteTeacherVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FavoriteTeacherService {
    List<FavoriteTeacherVo> findAll();
    FavoriteTeacherVo getFavTeacherById(Integer id);
    void createFavTeacher(FavoriteTeacherVo favoriteTeacher);
    void deleteFavTeacher(Integer id);
}
