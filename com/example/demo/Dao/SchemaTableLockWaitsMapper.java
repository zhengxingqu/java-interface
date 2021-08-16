package com.example.demo.Dao;

import com.example.demo.Model.SchemaTableLockWaitsWithBLOBs;

public interface SchemaTableLockWaitsMapper {
    int insert(SchemaTableLockWaitsWithBLOBs record);

    int insertSelective(SchemaTableLockWaitsWithBLOBs record);
}