package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.CourseVo;

public interface CourseDao {
    CourseVo getCourseById(Integer courseId);
}
