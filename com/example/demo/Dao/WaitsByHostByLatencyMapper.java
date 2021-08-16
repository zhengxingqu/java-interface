package com.example.demo.Dao;

import com.example.demo.Model.WaitsByHostByLatencyWithBLOBs;

public interface WaitsByHostByLatencyMapper {
    int insert(WaitsByHostByLatencyWithBLOBs record);

    int insertSelective(WaitsByHostByLatencyWithBLOBs record);
}