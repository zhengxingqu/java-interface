package com.example.demo.Dao;

import com.example.demo.Model.IoGlobalByFileByLatencyWithBLOBs;

public interface IoGlobalByFileByLatencyMapper {
    int insert(IoGlobalByFileByLatencyWithBLOBs record);

    int insertSelective(IoGlobalByFileByLatencyWithBLOBs record);
}