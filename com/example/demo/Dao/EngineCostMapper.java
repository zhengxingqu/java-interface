package com.example.demo.Dao;

import com.example.demo.Model.EngineCost;

public interface EngineCostMapper {
    int insert(EngineCost record);

    int insertSelective(EngineCost record);
}