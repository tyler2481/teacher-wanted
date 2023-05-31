package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.vo.CourseCommentVo;

import java.util.List;

public interface CourseCommentDao {
    List<CourseCommentVo> findAll();
    List<CourseCommentVo> getCommentsByCourseId(Integer courseId);

    CourseCommentVo getCommentsById(Integer id);
    void createComment(CourseCommentVo courseComment);
    void updateComment(CourseCommentVo courseComment);

    void deleteComment(Integer id);
}
