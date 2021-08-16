package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "module_management")
public class ModuleManagement {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;
    @Column(name = "moduleName")
    @NotBlank(message = "模块名不能为空")
    @NotNull(message = "模块名不能为null")
    private String moduleName;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "projectName")
    @NotBlank(message = "项目名称不能为空")
    @NotNull(message = "项目名称不能为null")
    private String projectName;
}
