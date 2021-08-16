package com.example.demo.Dao;

import com.example.demo.Model.EventsStatementsSummaryByHostByEventName;

public interface EventsStatementsSummaryByHostByEventNameMapper {
    int insert(EventsStatementsSummaryByHostByEventName record);

    int insertSelective(EventsStatementsSummaryByHostByEventName record);
}