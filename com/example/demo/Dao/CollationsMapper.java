package com.example.demo.Dao;

import com.example.demo.Model.Collations;

public interface CollationsMapper {
    int insert(Collations record);

    int insertSelective(Collations record);
}