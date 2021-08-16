package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsHistory;

public interface EventsTransactionsHistoryMapper {
    int insert(EventsTransactionsHistory record);

    int insertSelective(EventsTransactionsHistory record);
}