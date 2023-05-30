package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.model.vo.FavoriteTeacherVo;
import com.project3.teacherwanted.service.FavoriteCourseService;
import com.project3.teacherwanted.service.FavoriteTeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteTeacherController {
    @Autowired
    private FavoriteTeacherService favoriteTeacherService;

    @GetMapping("/favtea")
    public ResponseEntity<List<FavoriteTeacherVo>> findAll() {
        List<FavoriteTeacherVo> favoriteTeachersList = favoriteTeacherService.findAll();
        return new ResponseEntity<>(favoriteTeachersList, HttpStatus.OK);
    }

    @GetMapping("/favtea/{id}")
    public ResponseEntity<FavoriteTeacherVo> getFavTeacherById(@PathVariable("id") Integer id) {
        FavoriteTeacherVo favoriteTeacher = favoriteTeacherService.getFavTeacherById(id);
        return new ResponseEntity<>(favoriteTeacher, HttpStatus.OK);
    }

    @PostMapping("/favtea")
    public ResponseEntity<Void> createFavTeacher(@RequestBody @Valid FavoriteTeacherVo favoriteTeacher) {
        favoriteTeacherService.createFavTeacher(favoriteTeacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/favtea/{id}")
    public ResponseEntity<Void> deleteFavTeacher(@PathVariable("id") Integer id) {
        favoriteTeacherService.deleteFavTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
