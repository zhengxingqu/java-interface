package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.StatusCode;
import com.example.demo.model.CaseGroupManagement;
import com.example.demo.service.CaseGroupManagementService;
import com.example.demo.tool.PageResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/caseGroup")
@CrossOrigin
public class CaseGroupManagementController {
    @Autowired
    private CaseGroupManagementService caseGroupManagementService;

    @GetMapping(value = "/all")
    public Result findAllCaseGroup(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<CaseGroupManagement> pageInfo = caseGroupManagementService.findAllCaseGroup(page, size);
        PageResult pageResult = new PageResult<CaseGroupManagement>(pageInfo.getTotal(), pageInfo.getResult(), pageInfo.getPageNum(), pageInfo.getPageSize());
        return new Result("true", StatusCode.OK, "查询成功", pageResult);
    }

    @PostMapping(value = "/add")
    public Result insertCaseGroup(@RequestBody CaseGroupManagement caseGroupManagement) throws Exception {
        caseGroupManagementService.insertCaseGroup(caseGroupManagement);
        return new Result("true", StatusCode.OK, "新增成功", caseGroupManagement.getId());
    }

    @PutMapping(value = "/update/{id}")
    public Result updateCaseGroup(@RequestBody CaseGroupManagement caseGroupManagement, @PathVariable(value = "id") int id) throws Exception {
        caseGroupManagementService.updateCaseGroup(caseGroupManagement, id);
        CaseGroupManagement t = caseGroupManagementService.findCaseGroupById(id);
        return new Result("true", StatusCode.OK, "修改成功", t);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Result deleteCase(@PathVariable(value = "id") int id) {
        caseGroupManagementService.deleteCaseGroup(id);
        return new Result("true", StatusCode.OK, "删除成功");
    }

    @GetMapping(value = "/search")
    public Page<CaseGroupManagement> findSearchCaseGroup(Integer page, Integer size, CaseGroupManagement caseGroupManagement) {
        return caseGroupManagementService.findSearchCaseGroup(page, size, caseGroupManagement);
    }

}
