package com.example.demo.Dao;

import com.example.demo.Model.InnodbIndexStats;

public interface InnodbIndexStatsMapper {
    int insert(InnodbIndexStats record);

    int insertSelective(InnodbIndexStats record);
}