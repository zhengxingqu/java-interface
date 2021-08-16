package com.example.demo.Dao;

import com.example.demo.Model.ColumnPrivileges;

public interface ColumnPrivilegesMapper {
    int insert(ColumnPrivileges record);

    int insertSelective(ColumnPrivileges record);
}