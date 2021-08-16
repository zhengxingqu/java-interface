package com.example.demo.Dao;

import com.example.demo.Model.ReplicationApplierStatusByCoordinator;

public interface ReplicationApplierStatusByCoordinatorMapper {
    int insert(ReplicationApplierStatusByCoordinator record);

    int insertSelective(ReplicationApplierStatusByCoordinator record);
}