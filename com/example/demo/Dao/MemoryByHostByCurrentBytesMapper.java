package com.example.demo.Dao;

import com.example.demo.Model.MemoryByHostByCurrentBytesWithBLOBs;

public interface MemoryByHostByCurrentBytesMapper {
    int insert(MemoryByHostByCurrentBytesWithBLOBs record);

    int insertSelective(MemoryByHostByCurrentBytesWithBLOBs record);
}