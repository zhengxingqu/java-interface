package com.example.demo.Dao;

import com.example.demo.Model.XSchemaTableStatisticsWithBuffer;

public interface XSchemaTableStatisticsWithBufferMapper {
    int insert(XSchemaTableStatisticsWithBuffer record);

    int insertSelective(XSchemaTableStatisticsWithBuffer record);
}