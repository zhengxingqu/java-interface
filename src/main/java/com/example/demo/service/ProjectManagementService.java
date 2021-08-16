package com.example.demo.service;

import com.example.demo.model.ProjectManagement;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProjectManagementService {
    Page<ProjectManagement> findAllProject(int page, int size);

    ProjectManagement findProjectById(int id);

    void updateProject(ProjectManagement projectManagement);

    void insertProject(ProjectManagement projectManagement) throws Exception;

    void deleteProject(int id);

    Page<ProjectManagement> findSearchPage(Integer page, Integer size, ProjectManagement projectManagement);

    List findProjectName(String projectName);

    List getAllProject();
}
