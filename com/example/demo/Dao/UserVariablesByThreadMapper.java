package com.example.demo.Dao;

import com.example.demo.Model.UserVariablesByThread;

public interface UserVariablesByThreadMapper {
    int insert(UserVariablesByThread record);

    int insertSelective(UserVariablesByThread record);
}