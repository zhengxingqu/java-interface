package com.example.demo.Dao;

import com.example.demo.Model.TimeZoneLeapSecond;

public interface TimeZoneLeapSecondMapper {
    int insert(TimeZoneLeapSecond record);

    int insertSelective(TimeZoneLeapSecond record);
}