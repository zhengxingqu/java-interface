package com.example.demo.Dao;

import com.example.demo.Model.SchemaAutoIncrementColumns;

public interface SchemaAutoIncrementColumnsMapper {
    int insert(SchemaAutoIncrementColumns record);

    int insertSelective(SchemaAutoIncrementColumns record);
}