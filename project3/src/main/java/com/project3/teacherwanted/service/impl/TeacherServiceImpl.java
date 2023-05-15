package com.project3.teacherwanted.service.impl;

import com.project3.teacherwanted.dao.TeacherDao;
import com.project3.teacherwanted.model.vo.TeacherVo;
import com.project3.teacherwanted.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public List<TeacherVo> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    public TeacherVo getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }

    public void createTeacher(TeacherVo teacherVo) {
        teacherDao.createTeacher(teacherVo);
    }

    public void updateTeacher(TeacherVo teacherVo) {
        teacherDao.updateTeacher(teacherVo);
    }

    public void deleteTeacher(Integer id) {
        teacherDao.deleteTeacher(id);
    }
}
