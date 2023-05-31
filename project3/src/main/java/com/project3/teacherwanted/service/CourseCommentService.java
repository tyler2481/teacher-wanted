package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.vo.CourseCommentVo;

import java.util.List;

public interface CourseCommentService {
    List<CourseCommentVo> findAll();
    List<CourseCommentVo> getCommentsByCourseId(Integer courseId);

    CourseCommentVo getCommentsById(Integer id);
    void createComment(CourseCommentVo courseComment);
    void updateComment(CourseCommentVo courseComment);

    void deleteComment(Integer id);
}
