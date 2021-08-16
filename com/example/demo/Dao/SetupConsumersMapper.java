package com.example.demo.Dao;

import com.example.demo.Model.SetupConsumers;

public interface SetupConsumersMapper {
    int insert(SetupConsumers record);

    int insertSelective(SetupConsumers record);
}