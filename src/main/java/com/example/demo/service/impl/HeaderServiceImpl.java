package com.example.demo.service.impl;

import com.example.demo.mapper.HeaderManagementMapper;
import com.example.demo.model.HeaderManagement;
import com.example.demo.service.HeaderManagementService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderManagementService {
    @Autowired
    private HeaderManagementMapper headerManagementMapper;


    @Override
    public Page<HeaderManagement> findAllHeader(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<HeaderManagement>) headerManagementMapper.selectAll();
    }

    @Override
    public HeaderManagement findHeaderById(int id) {
        return headerManagementMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHeader(HeaderManagement headerManagement) {
        headerManagementMapper.updateByPrimaryKeySelective(headerManagement);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertHeader(HeaderManagement headerManagement) throws Exception {
        if (this.findHeaderName(headerManagement.getHeader()).size() == 0) {
            headerManagementMapper.insertSelective(headerManagement);
        } else {
            throw new Exception("请求头名称已存在");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteHeader(int id) {
        headerManagementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<HeaderManagement> findSearchHeader(Integer page, Integer size, HeaderManagement headerManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(HeaderManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (headerManagement != null) {
            if (!StringUtil.isEmpty(headerManagement.getHeader())) {
                criteria.andLike("header", "%" + headerManagement.getHeader() + "%");
            }
        }
        List<HeaderManagement> pageProject = headerManagementMapper.selectByExample(example);
        return (Page<HeaderManagement>) pageProject;
    }

    @Override
    public List findHeaderName(String header) {
        Example example = new Example(HeaderManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("header", header);
        return headerManagementMapper.selectByExample(example);
    }
}
