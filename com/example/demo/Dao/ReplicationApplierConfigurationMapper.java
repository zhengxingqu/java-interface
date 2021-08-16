package com.example.demo.Dao;

import com.example.demo.Model.ReplicationApplierConfiguration;

public interface ReplicationApplierConfigurationMapper {
    int insert(ReplicationApplierConfiguration record);

    int insertSelective(ReplicationApplierConfiguration record);
}