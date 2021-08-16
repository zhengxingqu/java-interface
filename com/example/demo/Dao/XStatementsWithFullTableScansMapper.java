package com.example.demo.Dao;

import com.example.demo.Model.XStatementsWithFullTableScans;

public interface XStatementsWithFullTableScansMapper {
    int insert(XStatementsWithFullTableScans record);

    int insertSelective(XStatementsWithFullTableScans record);
}