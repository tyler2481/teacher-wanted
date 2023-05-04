package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseVo>> getCourses(
            //查詢條件
            @RequestParam (required = false) CourseCategory category,
            @RequestParam (required = false) String search
            ){
        List<CourseVo> courseVoList = courseService.getCourses(category, search);
        return ResponseEntity.status(HttpStatus.OK).body(courseVoList);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseVo> getCourseById(@PathVariable Integer courseId){
        CourseVo courseVo = courseService.getCourseById(courseId);

        if(courseVo != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseVo> createCourse(@RequestBody @Valid CourseRequest courseRequest){
        Integer courseId = courseService.createCourse(courseRequest);
        CourseVo courseVo = courseService.getCourseById(courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseVo);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<CourseVo> updateCourse(@PathVariable Integer courseId,
                                                 @RequestBody @Valid CourseRequest courseRequest){
        CourseVo courseVo = courseService.getCourseById(courseId);
        if(courseVo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            courseService.updateCourse(courseId, courseRequest);
            CourseVo updatedCourse = courseService.getCourseById(courseId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
        }
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
