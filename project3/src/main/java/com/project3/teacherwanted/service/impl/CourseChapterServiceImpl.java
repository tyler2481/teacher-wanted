package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.CourseChapterDao;
import com.project3.teacherwanted.model.vo.CourseChapterVo;
import com.project3.teacherwanted.service.CourseChapterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseChapterServiceImpl implements CourseChapterService {
    @Autowired
    private CourseChapterDao courseChapterDao;

    @Override
    public List<CourseChapterVo> findByCourseId(Integer courseId) {
        return courseChapterDao.findByCourseId(courseId);
    }
    @Override
    public CourseChapterVo findById(Integer id) {
        return courseChapterDao.findById(id);
    }

    @Override
    public Integer createChapters(CourseChapterVo chapterVo) {
        return courseChapterDao.createChapters(chapterVo);
    }

    @Override
    public void updateChapter(Integer courseId, CourseChapterVo chapterVo) {
        courseChapterDao.updateChapter(courseId, chapterVo);
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        courseChapterDao.deleteCourseById(courseId);
    }
}
