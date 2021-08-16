package com.example.demo.Dao;

import com.example.demo.Model.Statistics;

public interface StatisticsMapper {
    int insert(Statistics record);

    int insertSelective(Statistics record);
}