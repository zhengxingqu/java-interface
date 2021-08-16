package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
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
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public Result findAllUser(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<User> pageInfo = userService.findAllUser(page, size);
        PageResult pageResult = new PageResult<User>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createUser(@Validated @RequestBody User user) throws Exception {
        userService.insertUser(user);
        return new Result("true", StatusCode.OK, "新增成功", user.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") int id) throws Exception {
        if (userService.findUser(user.getEmail()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(userService.findUser(user.getEmail()), new TypeToken<List<User>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                user.setId(id);
                userService.updateUser(user);
                User t = userService.findUserById(id);
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("项目名称已存在");
            }
        } else {
            user.setId(id);
            userService.updateUser(user);
            User t = userService.findUserById(id);
            return new Result("true", StatusCode.OK, "修改成功");
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteProject(@PathVariable(value = "id") int id) {
        userService.deleteUser(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchProject(Integer page, Integer size, User user) {
        Page<User> pageInfo = userService.findSearchPage(page, size, user);
        PageResult pageResult = new PageResult<User>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

}
