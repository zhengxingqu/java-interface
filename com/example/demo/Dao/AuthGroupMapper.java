package com.example.demo.Dao;

import com.example.demo.Model.AuthGroup;

public interface AuthGroupMapper {
    int insert(AuthGroup record);

    int insertSelective(AuthGroup record);
}