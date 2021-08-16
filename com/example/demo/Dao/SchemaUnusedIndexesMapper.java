package com.example.demo.Dao;

import com.example.demo.Model.SchemaUnusedIndexes;

public interface SchemaUnusedIndexesMapper {
    int insert(SchemaUnusedIndexes record);

    int insertSelective(SchemaUnusedIndexes record);
}