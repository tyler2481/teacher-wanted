package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.constant.Category;
import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.model.dto.CourseQueryParams;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

//    @Override
//    public Integer countCourse(CourseQueryParams courseQueryParams) {
//        return courseDao.countCourse(courseQueryParams);
//    }
    @Override
    public List<CourseVo> getCourses(int page, int pageSize, Integer courseCategoryId, String keyword) {
        return courseDao.getCourses(page, pageSize, courseCategoryId, keyword);
    }

    @Override
    public CourseVo getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public List<CourseVo> getCoursesByKeyword(String keyword) {
        return courseDao.getCoursesByKeyword(keyword);
    }

    @Override
    public List<CourseVo> getCoursesByTeacher(Integer teaId) {
        return courseDao.getCoursesByTeacher(teaId);
    }

    @Override
    public Integer createCourse(CourseVo courseVo) throws IOException {
        return courseDao.createCourse(courseVo);
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
