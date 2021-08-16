package com.example.demo.Dao;

import com.example.demo.Model.GtidExecuted;

public interface GtidExecutedMapper {
    int insert(GtidExecuted record);

    int insertSelective(GtidExecuted record);
}