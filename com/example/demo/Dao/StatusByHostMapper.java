package com.example.demo.Dao;

import com.example.demo.Model.StatusByHost;

public interface StatusByHostMapper {
    int insert(StatusByHost record);

    int insertSelective(StatusByHost record);
}