package com.example.demo.Dao;

import com.example.demo.Model.EventsTransactionsCurrent;

public interface EventsTransactionsCurrentMapper {
    int insert(EventsTransactionsCurrent record);

    int insertSelective(EventsTransactionsCurrent record);
}