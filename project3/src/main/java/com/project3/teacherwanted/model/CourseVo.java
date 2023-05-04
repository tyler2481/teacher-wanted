package com.project3.teacherwanted.model;

import java.util.Date;

public class CourseVo {
    Integer courseId;
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
    Date createTime;
    Date updateTime;

    public CourseVo() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    public Integer getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Integer coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Double getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(Double courseLength) {
        this.courseLength = courseLength;
    }

    public Integer getCoolingOffPeriod() {
        return coolingOffPeriod;
    }

    public void setCoolingOffPeriod(Integer coolingOffPeriod) {
        this.coolingOffPeriod = coolingOffPeriod;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public Integer getCourseTotalRank() {
        return courseTotalRank;
    }

    public void setCourseTotalRank(Integer courseTotalRank) {
        this.courseTotalRank = courseTotalRank;
    }

    public Integer getCourseTotalEvaluate() {
        return courseTotalEvaluate;
    }

    public void setCourseTotalEvaluate(Integer courseTotalEvaluate) {
        this.courseTotalEvaluate = courseTotalEvaluate;
    }

    public Integer getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(Integer boughtCount) {
        this.boughtCount = boughtCount;
    }

    public String getCourseRemarks() {
        return courseRemarks;
    }

    public void setCourseRemarks(String courseRemarks) {
        this.courseRemarks = courseRemarks;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
