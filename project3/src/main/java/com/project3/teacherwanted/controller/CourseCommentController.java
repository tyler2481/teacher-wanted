package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.dto.CommentsResponse;
import com.project3.teacherwanted.model.vo.CourseCommentVo;
import com.project3.teacherwanted.model.vo.CourseVo;
import com.project3.teacherwanted.model.vo.MemberVo;
import com.project3.teacherwanted.service.CourseCommentService;
import com.project3.teacherwanted.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CourseCommentController {
    @Autowired
    private CourseCommentService courseCommentService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/comments")
    public ResponseEntity<List<CourseCommentVo>> findAll() {
        List<CourseCommentVo> courseComments = courseCommentService.findAll();
        return new ResponseEntity<>(courseComments, HttpStatus.OK);
    }

//    @GetMapping("/comments/{courseId}")
//    public ResponseEntity<List<CourseCommentVo>> getCommentsByCourseId(@PathVariable("courseId") Integer courseId) {
//        List<CourseCommentVo> courseComments = courseCommentService.getCommentsByCourseId(courseId);
//        return new ResponseEntity<>(courseComments, HttpStatus.OK);
//    }
    @GetMapping("/comments/{courseId}")
    public ResponseEntity<CommentsResponse<CourseCommentVo, MemberVo>> getCommentsByCourseId(@PathVariable("courseId") Integer courseId) {
        List<CourseCommentVo> courseComments = courseCommentService.getCommentsByCourseId(courseId);
        List<MemberVo> members = new ArrayList<>();
        for (CourseCommentVo comment : courseComments) {
            Integer memId = comment.getMemId();
            MemberVo member = memberService.findById(memId);
            members.add(member);
        }
        CommentsResponse<CourseCommentVo, MemberVo> response = new CommentsResponse<>(courseComments, members);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
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
        CourseCommentVo commentVo = courseCommentService.getCommentsById(id);
        commentVo.setCommentStatus(courseComment.getCommentStatus());
        courseCommentService.updateComment(commentVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id) {
        courseCommentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
