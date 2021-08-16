package com.example.demo.Dao;

import com.example.demo.Model.ReplicationApplierStatus;

public interface ReplicationApplierStatusMapper {
    int insert(ReplicationApplierStatus record);

    int insertSelective(ReplicationApplierStatus record);
}