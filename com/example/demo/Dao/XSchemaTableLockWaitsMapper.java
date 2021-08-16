package com.example.demo.Dao;

import com.example.demo.Model.XSchemaTableLockWaitsWithBLOBs;

public interface XSchemaTableLockWaitsMapper {
    int insert(XSchemaTableLockWaitsWithBLOBs record);

    int insertSelective(XSchemaTableLockWaitsWithBLOBs record);
}