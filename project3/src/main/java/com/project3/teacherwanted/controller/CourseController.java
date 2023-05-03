package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseVo> getCourseById(@PathVariable Integer courseId){
        CourseVo courseVo = courseService.getCourseById(courseId);

        if(courseVo != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
