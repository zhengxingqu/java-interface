package com.example.demo.Dao;

import com.example.demo.Model.PerformanceTimers;

public interface PerformanceTimersMapper {
    int insert(PerformanceTimers record);

    int insertSelective(PerformanceTimers record);
}