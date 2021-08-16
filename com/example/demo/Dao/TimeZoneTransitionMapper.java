package com.example.demo.Dao;

import com.example.demo.Model.TimeZoneTransition;

public interface TimeZoneTransitionMapper {
    int insert(TimeZoneTransition record);

    int insertSelective(TimeZoneTransition record);
}