package com.example.demo.Dao;

import com.example.demo.Model.Threads;

public interface ThreadsMapper {
    int insert(Threads record);

    int insertSelective(Threads record);
}