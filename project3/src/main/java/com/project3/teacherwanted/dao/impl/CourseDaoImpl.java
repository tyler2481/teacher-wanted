package com.project3.teacherwanted.dao.impl;

import com.project3.teacherwanted.dao.CourseDao;
import com.project3.teacherwanted.model.CourseVo;
import com.project3.teacherwanted.rowmapper.CourseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
}
