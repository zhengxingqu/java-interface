package com.example.demo.Dao;

import com.example.demo.Model.ReplicationConnectionStatus;

public interface ReplicationConnectionStatusMapper {
    int insert(ReplicationConnectionStatus record);

    int insertSelective(ReplicationConnectionStatus record);
}