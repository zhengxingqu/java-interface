package com.example.demo.Dao;

import com.example.demo.Model.XInnodbBufferStatsBySchema;

public interface XInnodbBufferStatsBySchemaMapper {
    int insert(XInnodbBufferStatsBySchema record);

    int insertSelective(XInnodbBufferStatsBySchema record);
}