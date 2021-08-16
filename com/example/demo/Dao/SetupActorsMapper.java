package com.example.demo.Dao;

import com.example.demo.Model.SetupActors;

public interface SetupActorsMapper {
    int insert(SetupActors record);

    int insertSelective(SetupActors record);
}