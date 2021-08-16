package com.example.demo.Dao;

import com.example.demo.Model.WaitClassesGlobalByLatencyWithBLOBs;

public interface WaitClassesGlobalByLatencyMapper {
    int insert(WaitClassesGlobalByLatencyWithBLOBs record);

    int insertSelective(WaitClassesGlobalByLatencyWithBLOBs record);
}