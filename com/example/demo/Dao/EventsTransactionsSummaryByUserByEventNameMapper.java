package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsSummaryByUserByEventName;

public interface EventsTransactionsSummaryByUserByEventNameMapper {
    int insert(EventsTransactionsSummaryByUserByEventName record);

    int insertSelective(EventsTransactionsSummaryByUserByEventName record);
}