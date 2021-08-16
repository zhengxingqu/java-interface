package com.example.demo.Dao;

import com.example.demo.Model.MemoryByUserByCurrentBytesWithBLOBs;

public interface MemoryByUserByCurrentBytesMapper {
    int insert(MemoryByUserByCurrentBytesWithBLOBs record);

    int insertSelective(MemoryByUserByCurrentBytesWithBLOBs record);
}