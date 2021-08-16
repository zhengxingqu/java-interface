package com.example.demo.Dao;

import com.example.demo.Model.Schemata;

public interface SchemataMapper {
    int insert(Schemata record);

    int insertSelective(Schemata record);
}