package com.example.demo.Dao;

import com.example.demo.Model.SchemaIndexStatisticsWithBLOBs;

public interface SchemaIndexStatisticsMapper {
    int insert(SchemaIndexStatisticsWithBLOBs record);

    int insertSelective(SchemaIndexStatisticsWithBLOBs record);
}