package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.constant.Category;
import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.model.dto.CourseQueryParams;
import com.project3.teacherwanted.model.dto.CourseRequest;
import com.project3.teacherwanted.model.vo.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import com.project3.teacherwanted.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("/CourseAll")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/Courses")
    public String getPage(Model model) {
        model.addAttribute("title", "My Page");
        return "Courses"; // 課程首頁
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseVo>> getCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int pageSize,
            //查詢條件
            @RequestParam (required = false) CourseCategory category,
            @RequestParam (required = false) String keyword
            ) {
        Integer courseCategoryId = null;
        if (category != null) {
            courseCategoryId = category.getCategoryId();
            List<CourseVo> courseVoList = courseService.getCourses(page, pageSize, courseCategoryId, keyword);
            return new ResponseEntity<>(courseVoList, HttpStatus.OK);
        }
        //取得CourseList
        List<CourseVo> courseVoList = courseService.getCourses(page, pageSize, courseCategoryId, keyword);

        return new ResponseEntity<>(courseVoList, HttpStatus.OK);

    }
    @GetMapping("/courses/{keyword}")
    public ResponseEntity<List<CourseVo>> getCoursesByKeyword(@PathVariable String keyword){
        List<CourseVo> courseVoList = courseService.getCoursesByKeyword(keyword);

        if(courseVoList != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVoList);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/TeacherCourses/{teaId}")
    public ResponseEntity<List<CourseVo>> getCoursesByTeacher(@PathVariable Integer teaId){
        List<CourseVo> courseVoList = courseService.getCoursesByTeacher(teaId);

        if(courseVoList != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVoList);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<CourseVo> getCourseById(@PathVariable Integer courseId){
        CourseVo courseVo = courseService.getCourseById(courseId);

        if(courseVo != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseVo> createCourse(@RequestBody @Valid CourseVo courseVo) throws IOException {
        Integer courseId = courseService.createCourse(courseVo);
        CourseVo courseVoReturn = courseService.getCourseById(courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseVoReturn);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<CourseVo> updateCourse(@PathVariable Integer courseId,
                                                 @RequestBody @Valid CourseRequest courseRequest){
        CourseVo courseVo = courseService.getCourseById(courseId);
        if(courseVo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            courseService.updateCourse(courseId, courseRequest);
            CourseVo updatedCourse = courseService.getCourseById(courseId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCourse);
        }
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
