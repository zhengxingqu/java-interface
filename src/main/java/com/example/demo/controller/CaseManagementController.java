package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.CaseManagement;
import com.example.demo.service.CaseManagementService;
import com.example.demo.service.EnvironmentalManagementService;
import com.example.demo.service.ModuleManagementService;
import com.example.demo.tool.PageResult;
import com.github.pagehelper.Page;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/case")
@CrossOrigin
public class CaseManagementController {
    @Autowired
    private CaseManagementService caseManagementService;

    @Autowired
    private ModuleManagementService moduleManagementService;

    @Autowired
    private EnvironmentalManagementService environmentalManagementService;

    private static final Logger logger = LoggerFactory.getLogger(CaseManagementController.class);


    @GetMapping(value = "/all")
    public Result findAllCase(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<CaseManagement> pageInfo = caseManagementService.findAllCase(page, size);
        PageResult pageResult = new PageResult<CaseManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result createCase(@Validated @RequestBody CaseManagement caseManagement) throws Exception {
        caseManagementService.insertCase(caseManagement);
        return new Result("true", StatusCode.OK, "新增成功", caseManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateCase(@Valid @RequestBody CaseManagement caseManagement, @PathVariable(value = "id") int id) throws Exception {
        if (caseManagementService.findCaseName(caseManagement.getCaseName()).size() >= 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(caseManagementService.findCaseName(caseManagement.getCaseName()), new TypeToken<List<CaseManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                caseManagement.setId(id);
                caseManagementService.updateCase(caseManagement);
                CaseManagement t = caseManagementService.findCaseById(id);
                return new Result("true", StatusCode.OK, "修改成功", t);
            } else {
                throw new Exception("请求头名称已存在");
            }
        } else {
            caseManagement.setId(id);
            caseManagementService.updateCase(caseManagement);
            CaseManagement t = caseManagementService.findCaseById(id);
            return new Result("true", StatusCode.OK, "修改成功", t);
        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteCase(@PathVariable(value = "id") int id) {
        logger.error(String.valueOf(id));
        try {
            caseManagementService.deleteCase(id);
        }catch (Exception e){
            logger.error(String.valueOf(e));
        }

        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Result searchCaseName(Integer page, Integer size, CaseManagement caseManagement) {
        Page<CaseManagement> pageInfo = caseManagementService.findSearchCase(page, size, caseManagement);
        PageResult pageResult = new PageResult<CaseManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/request/{id}")
    public Result interfaceRequest(@PathVariable(value = "id") int id, @RequestBody Map map) throws Exception {
        caseManagementService.interfaceRequest(map, id);
        return new Result("true", StatusCode.OK, "运行成功");
    }

    @DeleteMapping(value = "/deletes")
    public Result deleteCases(@RequestBody Map map) throws InterruptedException {
        caseManagementService.deleteCases(map);
        return new Result("true", StatusCode.OK, "查询成功");
    }

    @PostMapping(value = "/request")
    public Result runManyInterfaceRequest(@RequestBody Map map) throws Exception {
        if (map.get("envName").toString().equals("")) {
            throw new Exception("请选择环境名称");
        }
        caseManagementService.runManyInterfaceRequest(map);
        return new Result("true", StatusCode.OK, "运行成功");
    }

    @PostMapping(value = "/copy")
    public Result copyCase(@RequestBody CaseManagement caseManagement) {
        caseManagementService.copyCase(caseManagement);
        return new Result("true", StatusCode.OK, "复制成功");
    }

    @GetMapping(value = "/all/caseName")
    public Result getCaseName() {
        return new Result("true", StatusCode.OK, "查询成功", caseManagementService.getCaseName());
    }

    @PostMapping(value = "/upload")
    public Result uploadExcel(@RequestBody MultipartFile file, CaseManagement caseManagement) throws Exception {
//        System.out.println(file.getInputStream().read());
//        PrintWriter t = new PrintWriter("test.xlsx");
//        t.write(file.getInputStream().read());
//        t.close();
//        return null;
        caseManagementService.uploadExcel(file, caseManagement);
        return new Result("true", StatusCode.OK, "新增成功");
    }

    @PostMapping(value = "/download")
    public void downloadExcel(@RequestBody Map ids){
        caseManagementService.downloadExcel(ids);
    }

}
