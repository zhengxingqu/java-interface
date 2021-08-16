package com.example.demo.Dao;

import com.example.demo.Model.WaitsGlobalByLatencyWithBLOBs;

public interface WaitsGlobalByLatencyMapper {
    int insert(WaitsGlobalByLatencyWithBLOBs record);

    int insertSelective(WaitsGlobalByLatencyWithBLOBs record);
}