package com.example.demo.Dao;

import com.example.demo.Model.VariablesByThread;

public interface VariablesByThreadMapper {
    int insert(VariablesByThread record);

    int insertSelective(VariablesByThread record);
}