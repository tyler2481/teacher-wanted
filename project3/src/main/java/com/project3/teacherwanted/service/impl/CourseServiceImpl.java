package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.dto.CourseQueryParams;
import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CourseVo> getCourses(CourseQueryParams courseQueryParams) {
        return courseDao.getCourses(courseQueryParams);
    }

    @Override
    public CourseVo getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public Integer createCourse(CourseRequest courseRequest) {
        return courseDao.createCourse(courseRequest);
    }

    @Override
    public void updateCourse(Integer courseId, CourseRequest courseRequest) {
        courseDao.updateCourse(courseId, courseRequest);
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        courseDao.deleteCourseById(courseId);
    }
}
