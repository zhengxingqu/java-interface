package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsHistoryLongWithBLOBs;

public interface EventsStatementsHistoryLongMapper {
    int insert(EventsStatementsHistoryLongWithBLOBs record);

    int insertSelective(EventsStatementsHistoryLongWithBLOBs record);
}