package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsHistoryWithBLOBs;

public interface EventsStatementsHistoryMapper {
    int insert(EventsStatementsHistoryWithBLOBs record);

    int insertSelective(EventsStatementsHistoryWithBLOBs record);
}