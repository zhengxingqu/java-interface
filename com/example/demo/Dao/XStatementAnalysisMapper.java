package com.example.demo.Dao;

import com.example.demo.Model.XStatementAnalysis;

public interface XStatementAnalysisMapper {
    int insert(XStatementAnalysis record);

    int insertSelective(XStatementAnalysis record);
}