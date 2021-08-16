package com.example.demo.Model;

public class TimeZoneTransitionType {
    private Integer timeZoneId;

    private Integer transitionTypeId;

    private Integer offset;

    private Byte isDst;

    private String abbreviation;

    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(Integer timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Integer getTransitionTypeId() {
        return transitionTypeId;
    }

    public void setTransitionTypeId(Integer transitionTypeId) {
        this.transitionTypeId = transitionTypeId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Byte getIsDst() {
        return isDst;
    }

    public void setIsDst(Byte isDst) {
        this.isDst = isDst;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }
}