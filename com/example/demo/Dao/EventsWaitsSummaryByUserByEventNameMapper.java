package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsSummaryByUserByEventName;

public interface EventsWaitsSummaryByUserByEventNameMapper {
    int insert(EventsWaitsSummaryByUserByEventName record);

    int insertSelective(EventsWaitsSummaryByUserByEventName record);
}