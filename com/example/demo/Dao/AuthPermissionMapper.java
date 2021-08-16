package com.example.demo.Dao;

import com.example.demo.Model.AuthPermission;

public interface AuthPermissionMapper {
    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);
}