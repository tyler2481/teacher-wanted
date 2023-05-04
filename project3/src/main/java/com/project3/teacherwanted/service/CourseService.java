package com.project3.teacherwanted.service;

import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;

public interface CourseService {
    CourseVo getCourseById(Integer courseId);

    Integer createCourse(CourseRequest courseRequest);

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);
}
