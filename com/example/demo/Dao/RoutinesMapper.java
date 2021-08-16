package com.example.demo.Dao;

import com.example.demo.Model.RoutinesWithBLOBs;

public interface RoutinesMapper {
    int insert(RoutinesWithBLOBs record);

    int insertSelective(RoutinesWithBLOBs record);
}