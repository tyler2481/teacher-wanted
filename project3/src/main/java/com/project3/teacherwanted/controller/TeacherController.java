package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.model.vo.TeacherVo;
import com.project3.teacherwanted.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TeacherInfo.html"); // 填寫你的 HTML 檔案名稱
        return modelAndView;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherVo>> getAllTeachers() {
        List<TeacherVo> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherVo> getTeacherById(@PathVariable("id") Integer id) {
        TeacherVo teacher = teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Void> createTeacher(@RequestBody @Valid TeacherVo teacherVo) {
        teacherService.createTeacher(teacherVo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable("id") Integer id, @RequestBody @Valid TeacherVo teacherVo) {
        teacherVo.setTeaId(id);
        teacherService.updateTeacher(teacherVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Integer id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
