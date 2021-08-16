package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "environmental_management")
public class EnvironmentalManagement {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;
    @Column(name = "environmentalName")
    @NotBlank(message = "环境名称不能为空")
    @NotNull(message = "环境名称不能为null")
    private String environmentalName;
    @Column(name = "environmentalUrl")
    @NotBlank(message = "环境url不能为空")
    @NotNull(message = "环境ulr不能为null")
    private String environmentalUrl;
    @Column(name = "createTime")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnvironmentalName() {
        return environmentalName;
    }

    public void setEnvironmentalName(String environmentalName) {
        this.environmentalName = environmentalName;
    }

    public String getEnvironmentalUrl() {
        return environmentalUrl;
    }

    public void setEnvironmentalUrl(String environmentalUrl) {
        this.environmentalUrl = environmentalUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
