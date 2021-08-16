package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsSummaryByThreadByEventName;

public interface EventsWaitsSummaryByThreadByEventNameMapper {
    int insert(EventsWaitsSummaryByThreadByEventName record);

    int insertSelective(EventsWaitsSummaryByThreadByEventName record);
}