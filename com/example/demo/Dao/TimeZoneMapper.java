package com.example.demo.Dao;

import com.example.demo.Model.TimeZone;

public interface TimeZoneMapper {
    int insert(TimeZone record);

    int insertSelective(TimeZone record);
}