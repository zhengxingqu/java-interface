package com.example.demo.Dao;

import com.example.demo.Model.Metrics;

public interface MetricsMapper {
    int insert(Metrics record);

    int insertSelective(Metrics record);
}