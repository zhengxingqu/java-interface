package com.example.demo.Dao;

import com.example.demo.Model.ColumnsWithBLOBs;

public interface ColumnsMapper {
    int insert(ColumnsWithBLOBs record);

    int insertSelective(ColumnsWithBLOBs record);
}