package com.example.demo.Dao;

import com.example.demo.Model.XStatementsWithTempTables;

public interface XStatementsWithTempTablesMapper {
    int insert(XStatementsWithTempTables record);

    int insertSelective(XStatementsWithTempTables record);
}