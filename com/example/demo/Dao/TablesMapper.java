package com.example.demo.Dao;

import com.example.demo.Model.Tables;

public interface TablesMapper {
    int insert(Tables record);

    int insertSelective(Tables record);
}