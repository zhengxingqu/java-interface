package com.example.demo.Dao;

import com.example.demo.Model.InnodbBufferStatsByTableWithBLOBs;

public interface InnodbBufferStatsByTableMapper {
    int insert(InnodbBufferStatsByTableWithBLOBs record);

    int insertSelective(InnodbBufferStatsByTableWithBLOBs record);
}