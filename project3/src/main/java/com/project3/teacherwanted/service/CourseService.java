package com.project3.teacherwanted.service;

import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.dto.CourseQueryParams;
import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;

import java.util.List;

public interface CourseService {
    Integer countCourse(CourseQueryParams courseQueryParams);
    List<CourseVo> getCourses(CourseQueryParams courseQueryParams);
    CourseVo getCourseById(Integer courseId);

    Integer createCourse(CourseRequest courseRequest);

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);


}
