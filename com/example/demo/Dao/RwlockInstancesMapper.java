package com.example.demo.Dao;

import com.example.demo.Model.RwlockInstances;

public interface RwlockInstancesMapper {
    int insert(RwlockInstances record);

    int insertSelective(RwlockInstances record);
}