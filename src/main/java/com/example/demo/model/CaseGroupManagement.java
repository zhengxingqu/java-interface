package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "case_group_management")
public class CaseGroupManagement {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;

    @Column(name = "caseGroupName")
    @NotBlank(message = "用例组名称不能为空")
    @NotNull(message = "用例组名称不能为null")
    private String caseGroupName;
    @NotBlank(message = "用例名不能为空")
    @NotNull(message = "用例名不能为null")
    @Column(name = "caseName")
    private String caseName;

    @Column(name = "regex")
    private String regex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseGroupName() {
        return caseGroupName;
    }

    public void setCaseGroupName(String caseGroupName) {
        this.caseGroupName = caseGroupName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
