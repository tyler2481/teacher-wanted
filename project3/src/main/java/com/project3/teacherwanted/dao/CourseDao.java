package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.constant.Category;
import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.model.dto.CourseQueryParams;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;

import java.io.IOException;
import java.util.List;

public interface CourseDao {
//    Integer countCourse(CourseQueryParams courseQueryParams);
    List<CourseVo> getCourses(int page, int pageSize, Integer courseCategoryId, String keyword);
    CourseVo getCourseById(Integer courseId);

    List<CourseVo> getCoursesByKeyword(String keyword);
    List<CourseVo> getCoursesByTeacher(Integer teaId);

    Integer createCourse(CourseVo courseVo) throws IOException;

    void updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);

}
