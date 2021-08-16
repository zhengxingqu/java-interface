package com.example.demo.Dao;

import com.example.demo.Model.XSchemaTableStatistics;

public interface XSchemaTableStatisticsMapper {
    int insert(XSchemaTableStatistics record);

    int insertSelective(XSchemaTableStatistics record);
}