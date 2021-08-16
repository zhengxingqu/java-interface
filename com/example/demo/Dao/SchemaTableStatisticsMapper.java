package com.example.demo.Dao;

import com.example.demo.Model.SchemaTableStatisticsWithBLOBs;

public interface SchemaTableStatisticsMapper {
    int insert(SchemaTableStatisticsWithBLOBs record);

    int insertSelective(SchemaTableStatisticsWithBLOBs record);
}