package com.example.demo.Dao;

import com.example.demo.Model.StatementAnalysisWithBLOBs;

public interface StatementAnalysisMapper {
    int insert(StatementAnalysisWithBLOBs record);

    int insertSelective(StatementAnalysisWithBLOBs record);
}