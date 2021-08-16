package com.example.demo.Dao;

import com.example.demo.Model.SocketSummaryByInstance;

public interface SocketSummaryByInstanceMapper {
    int insert(SocketSummaryByInstance record);

    int insertSelective(SocketSummaryByInstance record);
}