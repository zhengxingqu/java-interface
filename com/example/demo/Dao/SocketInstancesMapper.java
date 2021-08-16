package com.example.demo.Dao;

import com.example.demo.Model.SocketInstances;

public interface SocketInstancesMapper {
    int insert(SocketInstances record);

    int insertSelective(SocketInstances record);
}