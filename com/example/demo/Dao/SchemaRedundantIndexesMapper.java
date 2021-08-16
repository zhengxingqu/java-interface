package com.example.demo.Dao;

import com.example.demo.Model.SchemaRedundantIndexesWithBLOBs;

public interface SchemaRedundantIndexesMapper {
    int insert(SchemaRedundantIndexesWithBLOBs record);

    int insertSelective(SchemaRedundantIndexesWithBLOBs record);
}