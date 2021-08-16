package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsSummaryByAccountByEventName;

public interface EventsTransactionsSummaryByAccountByEventNameMapper {
    int insert(EventsTransactionsSummaryByAccountByEventName record);

    int insertSelective(EventsTransactionsSummaryByAccountByEventName record);
}