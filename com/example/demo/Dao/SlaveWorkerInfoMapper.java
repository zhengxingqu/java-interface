package com.example.demo.Dao;

import com.example.demo.Model.SlaveWorkerInfoWithBLOBs;

public interface SlaveWorkerInfoMapper {
    int insert(SlaveWorkerInfoWithBLOBs record);

    int insertSelective(SlaveWorkerInfoWithBLOBs record);
}