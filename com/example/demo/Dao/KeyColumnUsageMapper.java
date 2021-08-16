package com.example.demo.Dao;

import com.example.demo.Model.KeyColumnUsage;

public interface KeyColumnUsageMapper {
    int insert(KeyColumnUsage record);

    int insertSelective(KeyColumnUsage record);
}