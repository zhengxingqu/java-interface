package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsSummaryByInstance;

public interface EventsWaitsSummaryByInstanceMapper {
    int insert(EventsWaitsSummaryByInstance record);

    int insertSelective(EventsWaitsSummaryByInstance record);
}