package com.example.demo.Dao;

import com.example.demo.Model.XInnodbBufferStatsByTableWithBLOBs;

public interface XInnodbBufferStatsByTableMapper {
    int insert(XInnodbBufferStatsByTableWithBLOBs record);

    int insertSelective(XInnodbBufferStatsByTableWithBLOBs record);
}