package com.example.demo.Dao;

import com.example.demo.Model.Db;

public interface DbMapper {
    int insert(Db record);

    int insertSelective(Db record);
}