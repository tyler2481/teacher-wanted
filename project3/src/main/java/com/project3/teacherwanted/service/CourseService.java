package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.dto.CourseQueryParams;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    Integer countCourse(CourseQueryParams courseQueryParams);
    List<CourseVo> getCourses(CourseQueryParams courseQueryParams);
    CourseVo getCourseById(Integer courseId);

    Integer createCourse(CourseRequest courseRequest) throws IOException;

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);


}
