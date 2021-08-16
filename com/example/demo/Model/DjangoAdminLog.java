package com.example.demo.Model;

import java.util.Date;

public class DjangoAdminLog {
    private Integer id;

    private Date actionTime;

    private String objectRepr;

    private Short actionFlag;

    private Integer contentTypeId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getObjectRepr() {
        return objectRepr;
    }

    public void setObjectRepr(String objectRepr) {
        this.objectRepr = objectRepr == null ? null : objectRepr.trim();
    }

    public Short getActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(Short actionFlag) {
        this.actionFlag = actionFlag;
    }

    public Integer getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}