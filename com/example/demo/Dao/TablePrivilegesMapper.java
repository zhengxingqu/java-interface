package com.example.demo.Dao;

import com.example.demo.Model.TablePrivileges;

public interface TablePrivilegesMapper {
    int insert(TablePrivileges record);

    int insertSelective(TablePrivileges record);
}