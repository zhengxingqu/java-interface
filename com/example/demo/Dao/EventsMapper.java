package com.example.demo.Dao;

import com.example.demo.Model.Events;

public interface EventsMapper {
    int insert(Events record);

    int insertSelective(Events record);
}