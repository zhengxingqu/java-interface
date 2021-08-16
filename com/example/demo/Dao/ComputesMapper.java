package com.example.demo.Dao;

import com.example.demo.Model.Computes;

public interface ComputesMapper {
    int insert(Computes record);

    int insertSelective(Computes record);
}