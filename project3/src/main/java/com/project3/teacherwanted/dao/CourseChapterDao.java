package com.project3.teacherwanted.dao;

import com.project3.teacherwanted.model.vo.CourseChapterVo;

import java.util.List;

public interface CourseChapterDao {
    List<CourseChapterVo> findByCourseId(Integer courseId);

    CourseChapterVo findById(Integer id);

    Integer createChapters(CourseChapterVo chapterVo);

    void updateChapter(Integer courseId, CourseChapterVo chapterVo);

    Integer deleteChaptersById(Integer courseId);

}
