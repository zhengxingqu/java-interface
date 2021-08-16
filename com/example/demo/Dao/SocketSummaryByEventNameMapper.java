package com.example.demo.Dao;

import com.example.demo.Model.SocketSummaryByEventName;

public interface SocketSummaryByEventNameMapper {
    int insert(SocketSummaryByEventName record);

    int insertSelective(SocketSummaryByEventName record);
}