package com.example.demo.Dao;

import com.example.demo.Model.IoGlobalByWaitByLatencyWithBLOBs;

public interface IoGlobalByWaitByLatencyMapper {
    int insert(IoGlobalByWaitByLatencyWithBLOBs record);

    int insertSelective(IoGlobalByWaitByLatencyWithBLOBs record);
}