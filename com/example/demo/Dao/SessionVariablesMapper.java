package com.example.demo.Dao;

import com.example.demo.Model.SessionVariables;

public interface SessionVariablesMapper {
    int insert(SessionVariables record);

    int insertSelective(SessionVariables record);
}