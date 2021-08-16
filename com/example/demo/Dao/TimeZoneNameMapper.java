package com.example.demo.Dao;

import com.example.demo.Model.TimeZoneName;

public interface TimeZoneNameMapper {
    int insert(TimeZoneName record);

    int insertSelective(TimeZoneName record);
}