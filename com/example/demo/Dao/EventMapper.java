package com.example.demo.Dao;

import com.example.demo.Model.EventWithBLOBs;

public interface EventMapper {
    int insert(EventWithBLOBs record);

    int insertSelective(EventWithBLOBs record);
}