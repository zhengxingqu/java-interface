package com.example.demo.Dao;

import com.example.demo.Model.AuthGroupPermissions;

public interface AuthGroupPermissionsMapper {
    int insert(AuthGroupPermissions record);

    int insertSelective(AuthGroupPermissions record);
}