package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.HeaderManagement;
import com.example.demo.service.HeaderManagementService;
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
@RequestMapping("/header")
@CrossOrigin
public class HeaderController {
    @Autowired
    private HeaderManagementService headerManagementService;

    @GetMapping(value = "/all")
    public Result findAllProject(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<HeaderManagement> pageInfo = headerManagementService.findAllHeader(page, size);
        PageResult pageResult = new PageResult<HeaderManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createProject(@Validated @RequestBody HeaderManagement headerManagement) throws Exception {
        headerManagementService.insertHeader(headerManagement);
        return new Result("true", StatusCode.OK, "新增成功", headerManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateProject(@Valid @RequestBody HeaderManagement headerManagement, @PathVariable(value = "id") int id) throws Exception {
        if (headerManagementService.findHeaderName(headerManagement.getHeader()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(headerManagementService.findHeaderName(headerManagement.getHeader()), new TypeToken<List<HeaderManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                headerManagement.setId(id);
                headerManagementService.updateHeader(headerManagement);
                HeaderManagement t = headerManagementService.findHeaderById(id);
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("请求头名称已存在");
            }
        } else {
            headerManagement.setId(id);
            headerManagementService.updateHeader(headerManagement);
            HeaderManagement t = headerManagementService.findHeaderById(id);

            return new Result("true", StatusCode.OK, "修改成功", t);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteProject(@PathVariable(value = "id") int id) {
        headerManagementService.deleteHeader(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchHeader(Integer page, Integer size, HeaderManagement headerManagement) {
        Page<HeaderManagement> pageInfo = headerManagementService.findSearchHeader(page, size, headerManagement);
        PageResult pageResult = new PageResult<HeaderManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

}
