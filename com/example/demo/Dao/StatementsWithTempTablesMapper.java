package com.example.demo.Dao;

import com.example.demo.Model.StatementsWithTempTablesWithBLOBs;

public interface StatementsWithTempTablesMapper {
    int insert(StatementsWithTempTablesWithBLOBs record);

    int insertSelective(StatementsWithTempTablesWithBLOBs record);
}