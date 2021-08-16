package com.example.demo.Model;

public class TimeZoneTransition {
    private Integer timeZoneId;

    private Long transitionTime;

    private Integer transitionTypeId;

    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(Integer timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Long getTransitionTime() {
        return transitionTime;
    }

    public void setTransitionTime(Long transitionTime) {
        this.transitionTime = transitionTime;
    }

    public Integer getTransitionTypeId() {
        return transitionTypeId;
    }

    public void setTransitionTypeId(Integer transitionTypeId) {
        this.transitionTypeId = transitionTypeId;
    }
}