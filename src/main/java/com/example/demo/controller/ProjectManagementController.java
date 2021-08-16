package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.ProjectManagement;
import com.example.demo.service.ProjectManagementService;
import com.example.demo.tool.PageResult;
import com.github.pagehelper.Page;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
@CrossOrigin
public class ProjectManagementController {
    @Autowired
    private ProjectManagementService projectManagementService;

    @GetMapping(value = "/all")
    public Result findAllProject(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<ProjectManagement> pageInfo = projectManagementService.findAllProject(page, size);
        PageResult pageResult = new PageResult<ProjectManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createProject(@Validated @RequestBody ProjectManagement projectManagement) throws Exception {
        projectManagementService.insertProject(projectManagement);
        return new Result("true", StatusCode.OK, "新增成功", projectManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateProject(@Valid @RequestBody ProjectManagement projectManagement, @PathVariable(value = "id") int id) throws Exception {
        if (projectManagementService.findProjectName(projectManagement.getProjectName()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(projectManagementService.findProjectName(projectManagement.getProjectName()), new TypeToken<List<ProjectManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                projectManagement.setId(id);
                projectManagementService.updateProject(projectManagement);
                ProjectManagement t = projectManagementService.findProjectById(id);
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("项目名称已存在");
            }
        } else {
            projectManagement.setId(id);
            projectManagementService.updateProject(projectManagement);
            ProjectManagement t = projectManagementService.findProjectById(id);
            return new Result("true", StatusCode.OK, "修改成功");
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteProject(@PathVariable(value = "id") int id) {
        projectManagementService.deleteProject(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchProject(Integer page, Integer size, ProjectManagement projectManagement) {
        Page<ProjectManagement> pageInfo = projectManagementService.findSearchPage(page, size, projectManagement);
        PageResult pageResult = new PageResult<ProjectManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @GetMapping(value = "/all/projectName")
    public Result getAllProjectName(){
        List projectNameList = projectManagementService.getAllProject();
        return new Result("true", StatusCode.OK, "查询成功", projectNameList);
    }


}
