package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.dto.CourseRequest;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.rowmapper.CourseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public CourseVo getCourseById(Integer courseId) {
        String sql = "select course_id, course_name, course_category_id, course_detail, course_price, " +
                " course_length, cooling_off_period, tea_id, course_total_rank, course_total_evaluate, " +
                " bought_count, course_remarks, course_status from COURSE where course_id = :courseId";

        Map<String, Object> map = new HashMap<>();
        map.put("courseId", courseId);


        List<CourseVo> courseVoList = namedParameterJdbcTemplate.query(sql, map, new CourseRowMapper());
        if (courseVoList.size() > 0){
            return courseVoList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public List<CourseVo> getCourses() {
        return null;
    }

    @Override
    public Integer createCourse(CourseRequest courseRequest) {
        String sql = "insert into COURSE(course_name, course_category_id, course_detail, course_price, " +
                     " course_length, cooling_off_period, tea_id, course_total_rank, course_total_evaluate, " +
                     " bought_count, course_remarks, course_status) " +
                     " values (:courseName, :courseCategoryId, :courseDetail, :coursePrice, :courseLength,  :coolingOffPeriod, " +
                     " :teaId, :courseTotalRank, :courseTotalEvaluate, :boughtCount, :courseRemarks, :courseStatus)";

        Map<String, Object> map = new HashMap<>();
        map.put("courseName", courseRequest.getCourseName());
        map.put("courseCategoryId", courseRequest.getCourseCategoryId());
        map.put("courseDetail", courseRequest.getCourseDetail());
        map.put("coursePrice", courseRequest.getCoursePrice());
        map.put("courseLength", courseRequest.getCourseLength());
        map.put("coolingOffPeriod", courseRequest.getCoolingOffPeriod());
        map.put("teaId", courseRequest.getTeaId());
        map.put("courseTotalRank", courseRequest.getCourseTotalRank());
        map.put("courseTotalEvaluate", courseRequest.getCourseTotalEvaluate());
        map.put("boughtCount", courseRequest.getBoughtCount());
        map.put("courseRemarks", courseRequest.getCourseRemarks());
        map.put("courseStatus", courseRequest.getCourseStatus());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int courseId = keyHolder.getKey().intValue();

        return courseId;
    }

    @Override
    public void updateCourse(Integer courseId, CourseRequest courseRequest) {
        String sql ="update COURSE set course_name = :courseName, course_category_id = :courseCategoryId, course_detail = :courseDetail, " +
                " course_price = :coursePrice, course_length = :courseLength, cooling_off_period = :coolingOffPeriod, course_total_rank = :courseTotalRank, " +
                " course_total_evaluate = :courseTotalEvaluate, bought_count = :boughtCount, course_remarks = :courseRemarks, course_status = :courseStatus where course_id = :courseId";

        Map<String, Object> map =new HashMap<>() ;
        map.put("courseId", courseId);
        map.put("courseName", courseRequest.getCourseName());
        map.put("courseCategoryId", courseRequest.getCourseCategoryId());
        map.put("courseDetail", courseRequest.getCourseDetail());
        map.put("coursePrice", courseRequest.getCoursePrice());
        map.put("courseLength", courseRequest.getCourseLength());
        map.put("coolingOffPeriod", courseRequest.getCoolingOffPeriod());
        map.put("courseTotalRank", courseRequest.getCourseTotalRank());
        map.put("courseTotalEvaluate", courseRequest.getCourseTotalEvaluate());
        map.put("boughtCount", courseRequest.getBoughtCount());
        map.put("courseRemarks", courseRequest.getCourseRemarks());
        map.put("courseStatus", courseRequest.getCourseStatus());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        String sql = "delete from COURSE where course_id = :courseId";

        Map<String, Object> map =new HashMap<>() ;

        map.put("courseId", courseId);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
