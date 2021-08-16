package com.example.demo.Dao;

import com.example.demo.Model.IoGlobalByWaitByBytesWithBLOBs;

public interface IoGlobalByWaitByBytesMapper {
    int insert(IoGlobalByWaitByBytesWithBLOBs record);

    int insertSelective(IoGlobalByWaitByBytesWithBLOBs record);
}