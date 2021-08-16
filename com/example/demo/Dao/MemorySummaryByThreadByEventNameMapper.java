package com.example.demo.Dao;

import com.example.demo.Model.MemorySummaryByThreadByEventName;

public interface MemorySummaryByThreadByEventNameMapper {
    int insert(MemorySummaryByThreadByEventName record);

    int insertSelective(MemorySummaryByThreadByEventName record);
}