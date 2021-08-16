package com.example.demo.Dao;

import com.example.demo.Model.EventsWaitsCurrent;

public interface EventsWaitsCurrentMapper {
    int insert(EventsWaitsCurrent record);

    int insertSelective(EventsWaitsCurrent record);
}