package com.project3.teacherwanted.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.File;

@Data
public class CourseRequest {
    String courseName;
    Integer courseCategoryId;
    String courseDetail;
    Integer coursePrice;
    Double courseLength;
    Integer coolingOffPeriod;
    Integer teaId;
    Integer courseTotalRank;
    Integer courseTotalEvaluate;
    Integer boughtCount;
    String courseRemarks;
    Integer courseStatus;

}
