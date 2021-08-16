package com.example.demo.Dao;

import com.example.demo.Model.DjangoSession;

public interface DjangoSessionMapper {
    int insert(DjangoSession record);

    int insertSelective(DjangoSession record);
}