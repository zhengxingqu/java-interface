package com.example.demo.Dao;

import com.example.demo.Model.MutexInstances;

public interface MutexInstancesMapper {
    int insert(MutexInstances record);

    int insertSelective(MutexInstances record);
}