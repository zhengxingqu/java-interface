package com.example.demo.service.impl;

import com.example.demo.mapper.ModuleManagementMapper;
import com.example.demo.model.ModuleManagement;
import com.example.demo.service.ModuleManagementService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
@Service
public class ModuleManagementImpl implements ModuleManagementService {
    @Autowired
    private ModuleManagementMapper moduleManagementMapper;


    @Override
    public Page<ModuleManagement> findAllModule(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<ModuleManagement>) moduleManagementMapper.selectAll();
    }

    @Override
    public ModuleManagement findModuleById(int id) {
        return moduleManagementMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateModule(ModuleManagement moduleManagement) {
        moduleManagementMapper.updateByPrimaryKeySelective(moduleManagement);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertModule(ModuleManagement moduleManagement) throws Exception {
        if (this.findModuleName(moduleManagement.getModuleName()).size() == 0) {
            Date time = new Date(System.currentTimeMillis());
            moduleManagement.setCreateTime(time);
            moduleManagementMapper.insertSelective(moduleManagement);
        } else {
            throw new Exception("模块名称已存在");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteModule(int id) {
        moduleManagementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<ModuleManagement> findSearchModule(Integer page, Integer size, ModuleManagement moduleManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(ModuleManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (moduleManagement != null) {
            if (!StringUtil.isEmpty(moduleManagement.getModuleName())) {
                criteria.andLike("moduleName", "%" + moduleManagement.getModuleName() + "%");
            }
        }
        List<ModuleManagement> pageProject = moduleManagementMapper.selectByExample(example);
        return (Page<ModuleManagement>) pageProject;
    }

    @Override
    public List findModuleName(String moduleName) {
        Example example = new Example(ModuleManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("moduleName", moduleName);
        return moduleManagementMapper.selectByExample(example);    }
}
