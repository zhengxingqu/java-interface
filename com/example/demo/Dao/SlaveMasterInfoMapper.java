package com.example.demo.Dao;

import com.example.demo.Model.SlaveMasterInfoWithBLOBs;

public interface SlaveMasterInfoMapper {
    int insert(SlaveMasterInfoWithBLOBs record);

    int insertSelective(SlaveMasterInfoWithBLOBs record);
}