package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsCurrentWithBLOBs;

public interface EventsStatementsCurrentMapper {
    int insert(EventsStatementsCurrentWithBLOBs record);

    int insertSelective(EventsStatementsCurrentWithBLOBs record);
}