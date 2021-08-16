package com.example.demo.Dao;

import com.example.demo.Model.WaitClassesGlobalByAvgLatencyWithBLOBs;

public interface WaitClassesGlobalByAvgLatencyMapper {
    int insert(WaitClassesGlobalByAvgLatencyWithBLOBs record);

    int insertSelective(WaitClassesGlobalByAvgLatencyWithBLOBs record);
}