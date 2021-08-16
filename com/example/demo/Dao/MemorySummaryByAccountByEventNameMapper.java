package com.example.demo.Dao;

import com.example.demo.Model.MemorySummaryByAccountByEventName;

public interface MemorySummaryByAccountByEventNameMapper {
    int insert(MemorySummaryByAccountByEventName record);

    int insertSelective(MemorySummaryByAccountByEventName record);
}