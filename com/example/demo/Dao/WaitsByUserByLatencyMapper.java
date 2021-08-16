package com.example.demo.Dao;

import com.example.demo.Model.WaitsByUserByLatencyWithBLOBs;

public interface WaitsByUserByLatencyMapper {
    int insert(WaitsByUserByLatencyWithBLOBs record);

    int insertSelective(WaitsByUserByLatencyWithBLOBs record);
}