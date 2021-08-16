package com.example.demo.Dao;

import com.example.demo.Model.SchemaObjectOverview;

public interface SchemaObjectOverviewMapper {
    int insert(SchemaObjectOverview record);

    int insertSelective(SchemaObjectOverview record);
}