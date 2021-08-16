package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsHistoryLong;

public interface EventsWaitsHistoryLongMapper {
    int insert(EventsWaitsHistoryLong record);

    int insertSelective(EventsWaitsHistoryLong record);
}