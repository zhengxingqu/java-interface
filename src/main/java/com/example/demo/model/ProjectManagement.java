package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "project_management")
public class ProjectManagement {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;
    @NotNull(message = "项目名不能为null")
    @NotBlank(message = "项目名不能为空")
    @Column(name = "projectName")
    private String projectName;
    @Column(name = "createTime")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
