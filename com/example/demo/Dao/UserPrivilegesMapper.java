package com.example.demo.Dao;

import com.example.demo.Model.UserPrivileges;

public interface UserPrivilegesMapper {
    int insert(UserPrivileges record);

    int insertSelective(UserPrivileges record);
}