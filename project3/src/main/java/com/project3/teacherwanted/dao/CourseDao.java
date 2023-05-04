package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;

import java.util.List;

public interface CourseDao {
    List<CourseVo> getCourses();
    CourseVo getCourseById(Integer courseId);

    Integer createCourse(CourseRequest courseRequest);

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);
}
