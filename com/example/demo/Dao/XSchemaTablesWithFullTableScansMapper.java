package com.example.demo.Dao;

import com.example.demo.Model.XSchemaTablesWithFullTableScans;

public interface XSchemaTablesWithFullTableScansMapper {
    int insert(XSchemaTablesWithFullTableScans record);

    int insertSelective(XSchemaTablesWithFullTableScans record);
}