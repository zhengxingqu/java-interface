package com.example.demo.Dao;

import com.example.demo.Model.StatusByThread;

public interface StatusByThreadMapper {
    int insert(StatusByThread record);

    int insertSelective(StatusByThread record);
}