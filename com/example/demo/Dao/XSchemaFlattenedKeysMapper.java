package com.example.demo.Dao;

import com.example.demo.Model.XSchemaFlattenedKeys;

public interface XSchemaFlattenedKeysMapper {
    int insert(XSchemaFlattenedKeys record);

    int insertSelective(XSchemaFlattenedKeys record);
}