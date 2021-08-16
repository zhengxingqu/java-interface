package com.example.demo.Dao;

import com.example.demo.Model.InnodbLockWaitsWithBLOBs;

public interface InnodbLockWaitsMapper {
    int insert(InnodbLockWaitsWithBLOBs record);

    int insertSelective(InnodbLockWaitsWithBLOBs record);
}