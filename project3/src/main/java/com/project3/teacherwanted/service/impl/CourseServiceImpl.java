package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public CourseVo getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }
}
