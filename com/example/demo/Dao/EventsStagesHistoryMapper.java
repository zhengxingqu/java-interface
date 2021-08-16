package com.example.demo.Dao;

import com.example.demo.Model.EventsStagesHistory;

public interface EventsStagesHistoryMapper {
    int insert(EventsStagesHistory record);

    int insertSelective(EventsStagesHistory record);
}