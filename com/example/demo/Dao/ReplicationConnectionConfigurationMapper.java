package com.example.demo.Dao;

import com.example.demo.Model.ReplicationConnectionConfiguration;

public interface ReplicationConnectionConfigurationMapper {
    int insert(ReplicationConnectionConfiguration record);

    int insertSelective(ReplicationConnectionConfiguration record);
}