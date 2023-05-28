package com.project3.teacherwanted.service;

import com.project3.teacherwanted.constant.Category;
import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.model.dto.CourseQueryParams;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CourseService {
//    Integer countCourse(CourseQueryParams courseQueryParams);
    List<CourseVo> getCourses(int page, int pageSize, Integer courseCategoryId, String keyword);
    CourseVo getCourseById(Integer courseId);

    List<CourseVo> getCoursesByKeyword(String keyword);
    Map<String, Object> getCoursesByTeacher(Integer teaId, int page, int pageSize, Integer courseCategoryId, String keyword);

    Integer createCourse(CourseVo courseVo) throws IOException;

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);


}
