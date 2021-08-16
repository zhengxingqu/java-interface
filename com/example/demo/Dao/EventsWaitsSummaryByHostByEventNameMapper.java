package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsSummaryByHostByEventName;

public interface EventsWaitsSummaryByHostByEventNameMapper {
    int insert(EventsWaitsSummaryByHostByEventName record);

    int insertSelective(EventsWaitsSummaryByHostByEventName record);
}