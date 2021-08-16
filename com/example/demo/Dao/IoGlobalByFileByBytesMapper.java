package com.example.demo.Dao;

import com.example.demo.Model.IoGlobalByFileByBytesWithBLOBs;

public interface IoGlobalByFileByBytesMapper {
    int insert(IoGlobalByFileByBytesWithBLOBs record);

    int insertSelective(IoGlobalByFileByBytesWithBLOBs record);
}