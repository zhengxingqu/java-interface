package com.example.demo.Dao;

import com.example.demo.Model.EventsStagesSummaryByHostByEventName;

public interface EventsStagesSummaryByHostByEventNameMapper {
    int insert(EventsStagesSummaryByHostByEventName record);

    int insertSelective(EventsStagesSummaryByHostByEventName record);
}