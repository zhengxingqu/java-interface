package com.example.demo.Dao;

import com.example.demo.Model.ReplicationApplierStatusByWorker;

public interface ReplicationApplierStatusByWorkerMapper {
    int insert(ReplicationApplierStatusByWorker record);

    int insertSelective(ReplicationApplierStatusByWorker record);
}