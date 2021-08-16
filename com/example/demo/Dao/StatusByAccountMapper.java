package com.example.demo.Dao;

import com.example.demo.Model.StatusByAccount;

public interface StatusByAccountMapper {
    int insert(StatusByAccount record);

    int insertSelective(StatusByAccount record);
}