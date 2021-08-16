package com.example.demo.Dao;

import com.example.demo.Model.Engines;

public interface EnginesMapper {
    int insert(Engines record);

    int insertSelective(Engines record);
}