package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.EnvironmentalManagement;
import com.example.demo.service.EnvironmentalManagementService;
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
@RequestMapping(value = "/environmental")
@CrossOrigin
public class EnvironmentalManagementController {
    @Autowired
    private EnvironmentalManagementService environmentalManagementService;

    @GetMapping(value = "/all")
    public Result findAllenvironmental(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<EnvironmentalManagement> pageInfo = environmentalManagementService.findAllEnvironmental(page, size);
        PageResult pageResult = new PageResult<EnvironmentalManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createenvironmental(@Validated @RequestBody EnvironmentalManagement environmentalManagement) throws Exception {
            environmentalManagementService.insertEnvironmental(environmentalManagement);
        return new Result("true", StatusCode.OK, "新增成功", environmentalManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateenvironmental(@Valid @RequestBody EnvironmentalManagement environmentalManagement, @PathVariable(value = "id") int id) throws Exception {
        if (environmentalManagementService.findEnvironmentalName(environmentalManagement.getEnvironmentalName()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(environmentalManagementService.findEnvironmentalName(environmentalManagement.getEnvironmentalName()), new TypeToken<List<EnvironmentalManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                environmentalManagement.setId(id);
                environmentalManagementService.updateEnvironmental(environmentalManagement);
                EnvironmentalManagement t = environmentalManagementService.findEnvironmentalById(id);
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("环境名称已存在");
            }
        } else {
            environmentalManagement.setId(id);
            environmentalManagementService.updateEnvironmental(environmentalManagement);
            EnvironmentalManagement t = environmentalManagementService.findEnvironmentalById(id);
            return new Result("true", StatusCode.OK, "修改成功", t);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteenvironmental(@PathVariable(value = "id") int id) {
        environmentalManagementService.deleteEnvironmental(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchenvironmental(Integer page, Integer size, EnvironmentalManagement environmentalManagement) {
        Page<EnvironmentalManagement> pageInfo = environmentalManagementService.findSearchEnvironmental(page, size, environmentalManagement);
        PageResult pageResult = new PageResult<EnvironmentalManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }
}
