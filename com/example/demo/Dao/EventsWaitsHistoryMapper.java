package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsHistory;

public interface EventsWaitsHistoryMapper {
    int insert(EventsWaitsHistory record);

    int insertSelective(EventsWaitsHistory record);
}