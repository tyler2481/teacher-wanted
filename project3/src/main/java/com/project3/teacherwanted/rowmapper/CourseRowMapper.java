package com.project3.teacherwanted.rowmapper;


import com.project3.teacherwanted.model.CourseVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<CourseVo> {

    @Override
    public CourseVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseId(rs.getInt("course_id"));
        courseVo.setCourseName(rs.getString("course_name"));
        courseVo.setCourseCategoryId(rs.getInt("course_category_id"));
        courseVo.setCourseDetail(rs.getString("course_detail"));
        courseVo.setCoursePrice(rs.getInt("course_price"));
        courseVo.setCourseLength(rs.getDouble("course_length"));
        courseVo.setCoolingOffPeriod(rs.getInt("cooling_off_period"));
        courseVo.setTeaId(rs.getInt("tea_id"));
        courseVo.setCourseTotalRank(rs.getInt("course_total_rank"));
        courseVo.setCourseTotalEvaluate(rs.getInt("course_total_evaluate"));
        courseVo.setBoughtCount(rs.getInt("bought_count"));
        courseVo.setCourseRemarks(rs.getString("course_remarks"));
        courseVo.setCourseStatus(rs.getInt("course_status"));
        return courseVo;
    }
}
