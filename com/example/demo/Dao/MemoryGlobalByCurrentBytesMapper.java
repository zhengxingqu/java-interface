package com.example.demo.Dao;

import com.example.demo.Model.MemoryGlobalByCurrentBytesWithBLOBs;

public interface MemoryGlobalByCurrentBytesMapper {
    int insert(MemoryGlobalByCurrentBytesWithBLOBs record);

    int insertSelective(MemoryGlobalByCurrentBytesWithBLOBs record);
}