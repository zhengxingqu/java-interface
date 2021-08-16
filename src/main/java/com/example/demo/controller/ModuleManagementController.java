package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.ModuleManagement;
import com.example.demo.service.ModuleManagementService;
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
@RequestMapping("/module")
@CrossOrigin
public class ModuleManagementController {
    @Autowired
    private ModuleManagementService moduleManagementService;

    @GetMapping(value = "/all")
    public Result findAllModule(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<ModuleManagement> pageInfo = moduleManagementService.findAllModule(page, size);
        PageResult pageResult = new PageResult<ModuleManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createModule(@Validated @RequestBody ModuleManagement moduleManagement) throws Exception {
        moduleManagementService.insertModule(moduleManagement);
        return new Result("true", StatusCode.OK, "新增成功", moduleManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateProject(@Valid @RequestBody ModuleManagement moduleManagement, @PathVariable(value = "id") int id) throws Exception {
        if (moduleManagementService.findModuleName(moduleManagement.getModuleName()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(moduleManagementService.findModuleName(moduleManagement.getModuleName()), new TypeToken<List<ModuleManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                moduleManagement.setId(id);
                moduleManagementService.updateModule(moduleManagement);
                ModuleManagement t = moduleManagementService.findModuleById(id);
                System.out.println(t.getCreateTime());
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("模块名称已存在");
            }
        } else {
            moduleManagement.setId(id);
            moduleManagementService.updateModule(moduleManagement);
            ModuleManagement t = moduleManagementService.findModuleById(id);
            return new Result("true", StatusCode.OK, "修改成功", t);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteModule(@PathVariable(value = "id") int id) {
        moduleManagementService.deleteModule(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchModule(Integer page, Integer size, ModuleManagement moduleManagement) {
        Page<ModuleManagement> pageInfo = moduleManagementService.findSearchModule(page, size, moduleManagement);
        PageResult pageResult = new PageResult<ModuleManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

}
