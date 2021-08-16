package com.example.demo.Dao;

import com.example.demo.Model.ServerCost;

public interface ServerCostMapper {
    int insert(ServerCost record);

    int insertSelective(ServerCost record);
}