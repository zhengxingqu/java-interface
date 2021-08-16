package com.example.demo.Dao;

import com.example.demo.Model.GlobalStatus;

public interface GlobalStatusMapper {
    int insert(GlobalStatus record);

    int insertSelective(GlobalStatus record);
}