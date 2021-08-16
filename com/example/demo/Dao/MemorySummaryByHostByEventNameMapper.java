package com.example.demo.Dao;

import com.example.demo.Model.MemorySummaryByHostByEventName;

public interface MemorySummaryByHostByEventNameMapper {
    int insert(MemorySummaryByHostByEventName record);

    int insertSelective(MemorySummaryByHostByEventName record);
}