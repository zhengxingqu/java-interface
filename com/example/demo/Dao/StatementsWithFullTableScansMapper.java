package com.example.demo.Dao;

import com.example.demo.Model.StatementsWithFullTableScansWithBLOBs;

public interface StatementsWithFullTableScansMapper {
    int insert(StatementsWithFullTableScansWithBLOBs record);

    int insertSelective(StatementsWithFullTableScansWithBLOBs record);
}