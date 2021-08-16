package com.example.demo.Dao;

import com.example.demo.Model.MemoryByThreadByCurrentBytesWithBLOBs;

public interface MemoryByThreadByCurrentBytesMapper {
    int insert(MemoryByThreadByCurrentBytesWithBLOBs record);

    int insertSelective(MemoryByThreadByCurrentBytesWithBLOBs record);
}