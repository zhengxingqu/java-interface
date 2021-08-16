package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsSummaryByThreadByEventName;

public interface EventsTransactionsSummaryByThreadByEventNameMapper {
    int insert(EventsTransactionsSummaryByThreadByEventName record);

    int insertSelective(EventsTransactionsSummaryByThreadByEventName record);
}