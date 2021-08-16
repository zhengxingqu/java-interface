package com.example.demo.Dao;

import com.example.demo.Model.FileInstances;

public interface FileInstancesMapper {
    int insert(FileInstances record);

    int insertSelective(FileInstances record);
}