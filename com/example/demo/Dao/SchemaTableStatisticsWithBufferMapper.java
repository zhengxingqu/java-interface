package com.example.demo.Dao;

import com.example.demo.Model.SchemaTableStatisticsWithBufferWithBLOBs;

public interface SchemaTableStatisticsWithBufferMapper {
    int insert(SchemaTableStatisticsWithBufferWithBLOBs record);

    int insertSelective(SchemaTableStatisticsWithBufferWithBLOBs record);
}