package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.vo.CourseCommentVo;
import com.project3.teacherwanted.service.CourseCommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseCommentController {
    @Autowired
    private CourseCommentService courseCommentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CourseCommentVo>> findAll() {
        List<CourseCommentVo> courseComments = courseCommentService.findAll();
        return new ResponseEntity<>(courseComments, HttpStatus.OK);
    }

    @GetMapping("/comments/{courseId}")
    public ResponseEntity<List<CourseCommentVo>> getCommentsByCourseId(@PathVariable("id") Integer courseId) {
        List<CourseCommentVo> courseComments = courseCommentService.getCommentsByCourseId(courseId);
        return new ResponseEntity<>(courseComments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CourseCommentVo> getCommentsById(@PathVariable("id") Integer id) {
        CourseCommentVo courseComment = courseCommentService.getCommentsById(id);
        return new ResponseEntity<>(courseComment, HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<Void> createComment(@RequestBody @Valid CourseCommentVo courseComment) {
        courseCommentService.createComment(courseComment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable("id") Integer id, @RequestBody @Valid CourseCommentVo courseComment) {
        courseComment.setCourseCommentId(id);
        courseCommentService.updateComment(courseComment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id) {
        courseCommentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
