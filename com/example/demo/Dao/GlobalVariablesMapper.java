package com.example.demo.Dao;

import com.example.demo.Model.GlobalVariables;

public interface GlobalVariablesMapper {
    int insert(GlobalVariables record);

    int insertSelective(GlobalVariables record);
}