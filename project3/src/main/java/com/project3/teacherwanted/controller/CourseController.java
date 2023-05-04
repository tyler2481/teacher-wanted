package com.project3.teacherwanted.controller;

import com.project3.teacherwanted.constant.CourseCategory;
import com.project3.teacherwanted.dto.CourseQueryParams;
import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.service.CourseService;
import com.project3.teacherwanted.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<Page<CourseVo>> getCourses(
            //查詢條件
            @RequestParam (required = false) CourseCategory category,
            @RequestParam (required = false) String search,
            //排序
            @RequestParam (defaultValue = "create_time") String orderBy,
            @RequestParam (defaultValue = "desc") String sort,
            //分頁
            @RequestParam (defaultValue = "4") @Max(100) @Min(0)Integer limit,
            @RequestParam (defaultValue = "0") @Min(0) Integer offset
            ){
        CourseQueryParams courseQueryParams = new CourseQueryParams();
        courseQueryParams.setCategory(category);
        courseQueryParams.setSearch(search);
        courseQueryParams.setOrderBy(orderBy);
        courseQueryParams.setSort(sort);

        //取得CourseList
        List<CourseVo> courseVoList = courseService.getCourses(courseQueryParams);

        //取得Course總筆數
        Integer total = courseService.countCourse(courseQueryParams);

        //分頁
        Page<CourseVo> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(courseVoList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseVo> getCourseById(@PathVariable Integer courseId){
        CourseVo courseVo = courseService.getCourseById(courseId);

        if(courseVo != null){
            return ResponseEntity.status(HttpStatus.OK).body(courseVo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseVo> createCourse(@RequestBody @Valid CourseRequest courseRequest){
        Integer courseId = courseService.createCourse(courseRequest);
        CourseVo courseVo = courseService.getCourseById(courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseVo);
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
