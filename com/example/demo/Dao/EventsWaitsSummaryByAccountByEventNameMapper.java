package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsSummaryByAccountByEventName;

public interface EventsWaitsSummaryByAccountByEventNameMapper {
    int insert(EventsWaitsSummaryByAccountByEventName record);

    int insertSelective(EventsWaitsSummaryByAccountByEventName record);
}