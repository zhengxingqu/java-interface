package com.example.demo.Dao;

import com.example.demo.Model.Tablespaces;

public interface TablespacesMapper {
    int insert(Tablespaces record);

    int insertSelective(Tablespaces record);
}