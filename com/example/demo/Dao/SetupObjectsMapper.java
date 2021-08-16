package com.example.demo.Dao;

import com.example.demo.Model.SetupObjects;

public interface SetupObjectsMapper {
    int insert(SetupObjects record);

    int insertSelective(SetupObjects record);
}