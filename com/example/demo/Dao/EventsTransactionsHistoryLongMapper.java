package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsHistoryLong;

public interface EventsTransactionsHistoryLongMapper {
    int insert(EventsTransactionsHistoryLong record);

    int insertSelective(EventsTransactionsHistoryLong record);
}