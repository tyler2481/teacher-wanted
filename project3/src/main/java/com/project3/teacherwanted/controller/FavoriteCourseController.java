package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.vo.FavoriteCourseVo;
import com.project3.teacherwanted.service.FavoriteCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteCourseController {
    @Autowired
    private FavoriteCourseService favoriteCourseService;

    @GetMapping("/favcourses")
    public ResponseEntity<List<FavoriteCourseVo>> findAll() {
        List<FavoriteCourseVo> favoriteCourseList = favoriteCourseService.findAll();
        return new ResponseEntity<>(favoriteCourseList, HttpStatus.OK);
    }

    @GetMapping("/favcourses/{id}")
    public ResponseEntity<FavoriteCourseVo> getFavCourseById(@PathVariable("id") Integer id) {
        FavoriteCourseVo favoriteCourse = favoriteCourseService.getFavCourseById(id);
        return new ResponseEntity<>(favoriteCourse, HttpStatus.OK);
    }

    @GetMapping("/favcourses/{memId}/{courseId}")
    public int checkFavCourse(@PathVariable("memId") Integer memId, @PathVariable("courseId") Integer courseId) {
        int result = favoriteCourseService.checkFavCourse(memId, courseId);
        return result;
    }

    @PostMapping("/favcourses")
    public ResponseEntity<Void> createFavCourse(@RequestBody @Valid FavoriteCourseVo favoriteCourse) {
        favoriteCourseService.createFavCourse(favoriteCourse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/favcourses/{memId}/{courseId}")
    public ResponseEntity<Void> deleteFavCourse(@PathVariable("memId") Integer memId, @PathVariable("courseId") Integer courseId) {
        favoriteCourseService.deleteFavCourse(memId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
