package com.project3.teacherwanted.model.vo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "FAVORITE_COURSE")
public class FavoriteCourseVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_course_id")
    private Integer favoriteCourseId;
    private Integer memId;
    private Integer courseId;
    private Date createTime;
}
