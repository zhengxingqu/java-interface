package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.CaseGroupMapper;
import com.example.demo.model.CaseGroupManagement;
import com.example.demo.service.CaseGroupManagementService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CaseGroupManagementImpl implements CaseGroupManagementService {
    @Autowired
    private CaseGroupMapper caseGroupMapper;

    @Override
    public Page<CaseGroupManagement> findAllCaseGroup(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<CaseGroupManagement>) caseGroupMapper.selectAll();
    }

    @Override
    public CaseGroupManagement findCaseGroupById(int id) {
        return caseGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateCaseGroup(CaseGroupManagement caseGroupManagement, Integer id) throws Exception {
        int caseGroupNumber = findCaseGroupName(caseGroupManagement.getCaseGroupName()).size();
        if (caseGroupNumber > 1) {
            Gson gson = new Gson();
            String jsonResult = gson.toJson(findCaseGroupName(caseGroupManagement.getCaseGroupName()), new TypeToken<List<CaseGroupManagement>>() {
            }.getType());
            JsonArray object = new JsonParser().parse(jsonResult).getAsJsonArray();
            JSONObject jsObj = JSON.parseObject(object.get(0).toString());
            if (jsObj.getString("id").equals(String.valueOf(id))) {
                caseGroupManagement.setId(id);
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                updateCaseGroup(caseGroupManagement, id);
//                CaseGroupManagement t = findCaseGroupById(id);
            } else {
                throw new Exception("用例组名称已存在");
            }
        } else {
            caseGroupManagement.setId(id);
            updateCaseGroup(caseGroupManagement, id);
        }

    }

    @Override
    public void insertCaseGroup(CaseGroupManagement caseGroupManagement) throws Exception {
        System.out.println(findCaseGroupName(caseGroupManagement.getCaseGroupName()).size());
        System.out.println(caseGroupManagement.getCaseGroupName());
        if (findCaseGroupName(caseGroupManagement.getCaseGroupName()).size() == 0) {
            caseGroupMapper.insertSelective(caseGroupManagement);
        } else {
            throw new Exception("用例组名称已存在");
        }
    }

    @Override
    public void deleteCaseGroup(int id) {
        caseGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<CaseGroupManagement> findSearchCaseGroup(Integer page, Integer size, CaseGroupManagement caseGroupManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(CaseGroupManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (caseGroupManagement != null) {
            if (!StringUtil.isEmpty(caseGroupManagement.getCaseGroupName())) {
                criteria.andLike("caseGroupName", "%" + caseGroupManagement.getCaseGroupName() + "%");
            }
        }
        List<CaseGroupManagement> pageProject = caseGroupMapper.selectByExample(example);
        return (Page<CaseGroupManagement>) pageProject;
    }

    @Override
    public List findCaseGroupName(String caseGroupName) {
        Example example = new Example(CaseGroupManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("caseGroupName", caseGroupName);
        return caseGroupMapper.selectByExample(example);
    }

    @Override
    public void deleteCaseGroups(Map map) throws InterruptedException {
        ArrayList ids = (ArrayList) map.get("ids");
        ids.forEach(id -> {
            Thread t = new Thread(() -> {
                synchronized (this) {
                    caseGroupMapper.deleteByPrimaryKey(id);
                }
            });
            t.start();
        });
    }

    @Override
    public void copyCase(CaseGroupManagement caseGroupManagement) {
        Random r = new Random(1);
        caseGroupManagement.setCaseName(String.valueOf(r.nextInt(100000)) + caseGroupManagement.getCaseGroupName());
        caseGroupMapper.insertSelective(caseGroupManagement);
    }

}
