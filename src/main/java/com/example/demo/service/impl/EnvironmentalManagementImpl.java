package com.example.demo.service.impl;

import com.example.demo.mapper.EnvironmentalManagementMapper;
import com.example.demo.model.EnvironmentalManagement;
import com.example.demo.service.EnvironmentalManagementService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
@Service
public class EnvironmentalManagementImpl implements EnvironmentalManagementService {
    @Autowired
    private EnvironmentalManagementMapper environmentalManagementMapper;

    @Override
    public Page<EnvironmentalManagement> findAllEnvironmental(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<EnvironmentalManagement>) environmentalManagementMapper.selectAll();    }

    @Override
    public EnvironmentalManagement findEnvironmentalById(int id) {
        return environmentalManagementMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEnvironmental(EnvironmentalManagement environmentalManagement) {
        environmentalManagementMapper.updateByPrimaryKeySelective(environmentalManagement);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertEnvironmental(EnvironmentalManagement environmentalManagement) throws Exception {
        if (this.findEnvironmentalName(environmentalManagement.getEnvironmentalName()).size() == 0) {
            environmentalManagementMapper.insertSelective(environmentalManagement);
        } else {
            throw new Exception("环境名称已存在");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteEnvironmental(int id) {
        environmentalManagementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<EnvironmentalManagement> findSearchEnvironmental(Integer page, Integer size, EnvironmentalManagement environmentalManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(EnvironmentalManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (environmentalManagement != null) {
            if (!StringUtil.isEmpty(environmentalManagement.getEnvironmentalName())) {
                criteria.andLike("environmentalName", "%" + environmentalManagement.getEnvironmentalName() + "%");
            }
        }
        List<EnvironmentalManagement> pageProject = environmentalManagementMapper.selectByExample(example);
        return (Page<EnvironmentalManagement>) pageProject;
    }

    @Override
    public List findEnvironmentalName(String environmentalName) {
        Example example = new Example(EnvironmentalManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("environmentalName", environmentalName);
        return environmentalManagementMapper.selectByExample(example);
    }

}
