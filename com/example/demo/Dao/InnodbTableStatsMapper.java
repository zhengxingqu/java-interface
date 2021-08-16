package com.example.demo.Dao;

import com.example.demo.Model.InnodbTableStats;

public interface InnodbTableStatsMapper {
    int insert(InnodbTableStats record);

    int insertSelective(InnodbTableStats record);
}