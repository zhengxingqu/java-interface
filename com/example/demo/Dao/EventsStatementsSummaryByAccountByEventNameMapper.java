package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsSummaryByAccountByEventName;

public interface EventsStatementsSummaryByAccountByEventNameMapper {
    int insert(EventsStatementsSummaryByAccountByEventName record);

    int insertSelective(EventsStatementsSummaryByAccountByEventName record);
}