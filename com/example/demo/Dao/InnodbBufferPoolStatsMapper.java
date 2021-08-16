package com.example.demo.Dao;

import com.example.demo.Model.InnodbBufferPoolStats;

public interface InnodbBufferPoolStatsMapper {
    int insert(InnodbBufferPoolStats record);

    int insertSelective(InnodbBufferPoolStats record);
}