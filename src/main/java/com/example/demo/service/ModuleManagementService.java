package com.example.demo.service;

import com.example.demo.model.ModuleManagement;
import com.github.pagehelper.Page;

import java.util.List;

public interface ModuleManagementService {
    Page<ModuleManagement> findAllModule(int page, int size);

    ModuleManagement findModuleById(int id);

    void updateModule(ModuleManagement moduleManagement);

    void insertModule(ModuleManagement moduleManagement) throws Exception;

    void deleteModule(int id);

    Page<ModuleManagement> findSearchModule(Integer page, Integer size, ModuleManagement moduleManagement);

    List findModuleName(String moduleName);
}
