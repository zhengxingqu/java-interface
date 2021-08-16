package com.example.demo.service.impl;

import com.example.demo.mapper.ProjectManagementMapper;
import com.example.demo.model.ProjectManagement;
import com.example.demo.service.ProjectManagementService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService {
    @Autowired
    private ProjectManagementMapper projectManagementMapper;


    @Override
    public Page<ProjectManagement> findAllProject(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<ProjectManagement>)projectManagementMapper.selectAll();
    }

    @Override
    public ProjectManagement findProjectById(int id) {
        return projectManagementMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProject(ProjectManagement projectManagement) {
        projectManagementMapper.updateByPrimaryKeySelective(projectManagement);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertProject(ProjectManagement projectManagement) throws Exception {
        if (this.findProjectName(projectManagement.getProjectName()).size() == 0) {
            projectManagementMapper.insertSelective(projectManagement);
        } else {
            throw new Exception("项目名称已存在");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProject(int id) {
        projectManagementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<ProjectManagement> findSearchPage(Integer page, Integer size, ProjectManagement projectManagement) {
        PageHelper.startPage(page, size);
        Example example = new Example(ProjectManagement.class);
        Example.Criteria criteria = example.createCriteria();
        if (projectManagement != null) {
            if (!StringUtil.isEmpty(projectManagement.getProjectName())) {
                criteria.andLike("projectName", "%" + projectManagement.getProjectName() + "%");
            }
        }
        List<ProjectManagement> pageProject = projectManagementMapper.selectByExample(example);
        return (Page<ProjectManagement>)pageProject;
    }

    @Override
    public List findProjectName(String projectName) {
        Example example = new Example(ProjectManagement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("projectName", projectName);
        return projectManagementMapper.selectByExample(example);
    }

    @Override
    public List getAllProject() {
        return projectManagementMapper.selectAll();
    }
}
