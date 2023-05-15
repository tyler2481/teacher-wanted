package com.project3.teacherwanted.service;

import com.project3.teacherwanted.model.vo.TeacherVo;

import java.util.List;

public interface TeacherService {
    List<TeacherVo> getAllTeachers();

    TeacherVo getTeacherById(Integer id);

    void createTeacher(TeacherVo teacherVo);

    void updateTeacher(TeacherVo teacherVo);

    void deleteTeacher(Integer id);
}
