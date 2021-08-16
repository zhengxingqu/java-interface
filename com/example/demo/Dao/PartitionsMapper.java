package com.example.demo.Dao;

import com.example.demo.Model.PartitionsWithBLOBs;

public interface PartitionsMapper {
    int insert(PartitionsWithBLOBs record);

    int insertSelective(PartitionsWithBLOBs record);
}