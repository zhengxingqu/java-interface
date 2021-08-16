package com.example.demo.Dao;

import com.example.demo.Model.InnodbBufferStatsBySchemaWithBLOBs;

public interface InnodbBufferStatsBySchemaMapper {
    int insert(InnodbBufferStatsBySchemaWithBLOBs record);

    int insertSelective(InnodbBufferStatsBySchemaWithBLOBs record);
}