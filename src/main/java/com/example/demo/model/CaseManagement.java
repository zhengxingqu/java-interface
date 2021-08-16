package com.example.demo.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "case_management")
public class CaseManagement {
    @Column(name = "id")
    @Id
//    @GeneratedValue(generator = "JDBC")
    private int id;
    @NotBlank(message = "用例名不能为空")
    @NotNull(message = "用例名不能为null")
    @Column(name = "caseName")
    private String caseName;
    @Column(name = "projectName")
    private String projectName;
    @NotBlank(message = "模块名称不能为空")
    @NotNull(message = "模块名称不能为null")
    @Column(name = "moduleName")
    private String moduleName;
    @Column(name = "createTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @NotBlank(message = "请求头不能为空")
    @NotNull(message = "请求头不能为null")
    @Column(name = "header")
    private String header;
    @NotBlank(message = "请求方式不能为空")
    @NotNull(message = "请求方式不能为null")
    @Column(name = "requestMethod")
    private String requestMethod;
    @NotBlank(message = "请求参数不能为空")
    @NotNull(message = "请求参数不能为null")
    @Column(name = "requestParam")
    private String requestParam;
    @NotBlank(message = "校验结果不能为空")
    @NotNull(message = "校验结果不能为null")
    @Column(name = "resultAssert")
    private String resultAssert;
    @Column(name = "result")
    private String result;
    @Column(name = "errorResponse")
    private String errorResponse;
    @Column(name = "assertMethod")
    private String assertMethod;
    @Column(name = "url")
    private String url;
    @Column(name = "regex")
    private String regex;
    @Column(name = "quoteCase")
    private String quoteCase;
    @Column(name = "switchs")
    private Boolean switchs;
    @Column(name = "regexName")
    private String regexName;

    public String getRegexName() {
        return regexName;
    }

    public void setRegexName(String regexName) {
        this.regexName = regexName;
    }

    public String getQuoteCase() {
        return quoteCase;
    }

    public void setQuoteCase(String quoteCase) {
        this.quoteCase = quoteCase;
    }

    public Boolean getSwitchs() {
        return switchs;
    }

    public void setSwitchs(Boolean switchs) {
        this.switchs = switchs;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAssertMethod() {
        return assertMethod;
    }

    public void setAssertMethod(String assertMethod) {
        this.assertMethod = assertMethod;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResultAssert() {
        return resultAssert;
    }

    public void setResultAssert(String resultAssert) {
        this.resultAssert = resultAssert;
    }
}
