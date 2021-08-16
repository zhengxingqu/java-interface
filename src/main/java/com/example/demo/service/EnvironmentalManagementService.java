package com.example.demo.service;

import com.example.demo.model.EnvironmentalManagement;
import com.github.pagehelper.Page;

import java.util.List;

public interface EnvironmentalManagementService {
    Page<EnvironmentalManagement> findAllEnvironmental(int page, int size);

    EnvironmentalManagement findEnvironmentalById(int id);

    void updateEnvironmental(EnvironmentalManagement environmentalManagement);

    void insertEnvironmental(EnvironmentalManagement environmentalManagement) throws Exception;

    void deleteEnvironmental(int id);

    Page<EnvironmentalManagement> findSearchEnvironmental(Integer page, Integer size, EnvironmentalManagement environmentalManagement);

    List findEnvironmentalName(String environmentalName);
}
