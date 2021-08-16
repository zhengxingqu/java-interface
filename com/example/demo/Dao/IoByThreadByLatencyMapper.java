package com.example.demo.Dao;

import com.example.demo.Model.IoByThreadByLatencyWithBLOBs;

public interface IoByThreadByLatencyMapper {
    int insert(IoByThreadByLatencyWithBLOBs record);

    int insertSelective(IoByThreadByLatencyWithBLOBs record);
}