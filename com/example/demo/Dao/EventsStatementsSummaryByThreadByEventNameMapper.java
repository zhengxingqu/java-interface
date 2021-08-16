package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsSummaryByThreadByEventName;

public interface EventsStatementsSummaryByThreadByEventNameMapper {
    int insert(EventsStatementsSummaryByThreadByEventName record);

    int insertSelective(EventsStatementsSummaryByThreadByEventName record);
}