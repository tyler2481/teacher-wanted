package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;

import java.util.List;

public interface CourseDao {
    CourseVo getCourseById(Integer courseId);
    List<CourseVo> getCourses();

    Integer createCourse(CourseRequest courseRequest);

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);
}
