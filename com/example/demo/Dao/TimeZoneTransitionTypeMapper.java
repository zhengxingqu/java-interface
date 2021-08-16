package com.example.demo.Dao;

import com.example.demo.Model.TimeZoneTransitionType;

public interface TimeZoneTransitionTypeMapper {
    int insert(TimeZoneTransitionType record);

    int insertSelective(TimeZoneTransitionType record);
}