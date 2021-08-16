package com.example.demo.Dao;

import com.example.demo.Model.SchemaTablesWithFullTableScans;

public interface SchemaTablesWithFullTableScansMapper {
    int insert(SchemaTablesWithFullTableScans record);

    int insertSelective(SchemaTablesWithFullTableScans record);
}