package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsSummaryByHostByEventName;

public interface EventsTransactionsSummaryByHostByEventNameMapper {
    int insert(EventsTransactionsSummaryByHostByEventName record);

    int insertSelective(EventsTransactionsSummaryByHostByEventName record);
}