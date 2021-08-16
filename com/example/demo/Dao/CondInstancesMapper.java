package com.example.demo.Dao;

import com.example.demo.Model.CondInstances;

public interface CondInstancesMapper {
    int insert(CondInstances record);

    int insertSelective(CondInstances record);
}