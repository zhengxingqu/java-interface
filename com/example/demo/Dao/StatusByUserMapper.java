package com.example.demo.Dao;

import com.example.demo.Model.StatusByUser;

public interface StatusByUserMapper {
    int insert(StatusByUser record);

    int insertSelective(StatusByUser record);
}