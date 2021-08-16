package com.example.demo.Dao;

import com.example.demo.Model.LatestFileIoWithBLOBs;

public interface LatestFileIoMapper {
    int insert(LatestFileIoWithBLOBs record);

    int insertSelective(LatestFileIoWithBLOBs record);
}